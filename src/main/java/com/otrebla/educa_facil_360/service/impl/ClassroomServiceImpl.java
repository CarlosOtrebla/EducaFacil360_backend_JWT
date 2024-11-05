package com.otrebla.educa_facil_360.service.impl;

import com.otrebla.educa_facil_360.dto.Classrom.ClassroomRequestDTO;
import com.otrebla.educa_facil_360.dto.Classrom.ClassroomResponseDTO;
import com.otrebla.educa_facil_360.dto.PageResponseDTO;
import com.otrebla.educa_facil_360.model.Classroom;
import com.otrebla.educa_facil_360.model.School;
import com.otrebla.educa_facil_360.repository.ClassroomRepository;
import com.otrebla.educa_facil_360.repository.SchoolRepository;
import com.otrebla.educa_facil_360.service.ClassroomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ClassroomServiceImpl implements ClassroomService {
    
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    
    
    
    @Override
    public ClassroomResponseDTO createClassroom(ClassroomRequestDTO classroomRequestDTO) {
        // Busca a escola associada com o ID fornecido no DTO
        School school = schoolRepository.findById(classroomRequestDTO.getSchoolId())
                .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada"));
        
        // Cria uma nova instância de Classroom e define seus atributos
        Classroom classroom = new Classroom();
        classroom.setName(classroomRequestDTO.getName());
        classroom.setPeriodOfTheDay(classroomRequestDTO.getPeriodOfTheDay());
        classroom.setClassroomEnum(classroomRequestDTO.getClassroomEnum());
        classroom.setSchool(school);  // Define a escola associada à sala
        
        // Salva a sala de aula no repositório
        Classroom savedClassroom = classroomRepository.save(classroom);
        return new ClassroomResponseDTO(savedClassroom);
    }
    
    
    public PageResponseDTO<ClassroomResponseDTO> getAllClassrooms(Pageable pageable) {
        return new PageResponseDTO<>(classroomRepository
                .findAll(pageable)
                .map(ClassroomResponseDTO::new));
    }


}
