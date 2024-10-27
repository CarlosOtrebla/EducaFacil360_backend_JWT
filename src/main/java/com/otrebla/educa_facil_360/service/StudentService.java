package com.otrebla.educa_facil_360.service;

import com.otrebla.educa_facil_360.dto.*;
import com.otrebla.educa_facil_360.dto.Student.StudentRequestDTO;
import com.otrebla.educa_facil_360.dto.Student.StudentResponseDTO;
import com.otrebla.educa_facil_360.dto.Student.StudentUpdateDTO;
import com.otrebla.educa_facil_360.exception.NotFoundException;
import com.otrebla.educa_facil_360.exception.RequestParamRequired;
import com.otrebla.educa_facil_360.model.Student;
import com.otrebla.educa_facil_360.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public StudentResponseDTO saveStudent(StudentRequestDTO studentRequestDto) {
        System.out.println("Dados do StudentRequestDTO: " + studentRequestDto);
        Student student = new Student(studentRequestDto);
        return new StudentResponseDTO(studentRepository.save(student));
    }
    
    public PageResponseDTO<StudentResponseDTO> getAllByFieldSearch(String field, String search, Pageable pageable) throws RequestParamRequired {
        if (Objects.equals(field, "name")) {
            return new PageResponseDTO<>(studentRepository
                    .findAllNonDeletedByName(search, pageable).map(StudentResponseDTO::new));
        }
        
        throw new RequestParamRequired();
    }
    
    public PageResponseDTO<StudentResponseDTO> getAllStudents(Pageable pageable) {
        return new PageResponseDTO<>(studentRepository
                .findAll(pageable)
                .map(StudentResponseDTO::new));
    }
    
    public StudentResponseDTO getStudentById(UUID id) throws NotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        return new StudentResponseDTO(student);
    }
    
    // Editar
    public StudentResponseDTO updateStudentById(UUID id, StudentUpdateDTO newStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        
        // Se algum campo for deixado em branco, mantém o dado antigo
        if (newStudentDto.getName() == null) newStudentDto.setName(student.getName());
        if (newStudentDto.getEmail() == null) newStudentDto.setEmail(student.getEmail());
        if (newStudentDto.getCpf() == null) newStudentDto.setCpf(student.getCpf());
        if (newStudentDto.getPhoneNumber() == null) newStudentDto.setPhoneNumber(student.getPhoneNumber());
        
        // Faz o PUT
        BeanUtils.copyProperties(newStudentDto, student,
                "id", "registerTime", "password", "active"); // Campos que eu quero que ele não copie
        
        return new StudentResponseDTO(studentRepository.save(student));
    }
    
    // Desabilitar
    public void toggleStudentActiveById(UUID id) {
        Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        student.setActive(!student.getActive());
        studentRepository.save(student);
    }
    
    // Excluir
    public void deleteStudentById(UUID id) {
        Student student = studentRepository.findNonDeletedById(id).orElseThrow(NotFoundException::new);
        student.setIsDeleted(true);
        studentRepository.save(student);
    }
    
    // Verifica se o email existe na base de dados.
    public boolean existsByEmail(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
    
    // Atualiza a senha
    public void updatePasswordByEmail(String email, String newPassword) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setPassword(newPassword);
            studentRepository.save(student);
        }
    }
}
