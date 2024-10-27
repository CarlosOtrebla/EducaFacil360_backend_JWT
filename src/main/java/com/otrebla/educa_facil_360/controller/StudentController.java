package com.otrebla.educa_facil_360.controller;

import java.net.URI;
import java.util.UUID;

import com.otrebla.educa_facil_360.dto.*;
import com.otrebla.educa_facil_360.dto.Student.StudentRequestDTO;
import com.otrebla.educa_facil_360.dto.Student.StudentResponseDTO;
import com.otrebla.educa_facil_360.dto.Student.StudentUpdateDTO;
import com.otrebla.educa_facil_360.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentRequestDto) {
        StudentResponseDTO savedStudent = studentService.saveStudent(studentRequestDto);
        
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getId())
                .toUri();
        
        return ResponseEntity.created(uri).body(savedStudent);
    }
    
    @GetMapping("/search")
    public ResponseEntity<PageResponseDTO<StudentResponseDTO>> getAllStudentsBySearch(
            @RequestParam("field") String field,
            @RequestParam("search") String search,
            @PageableDefault(page = 0, size = 10, sort = "registerTime", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponseDTO<StudentResponseDTO> page = studentService.getAllByFieldSearch(field, search, pageable);
        if (page.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }
    
    @GetMapping
    public ResponseEntity<PageResponseDTO<StudentResponseDTO>> getAllStudents(
            @PageableDefault(page = 0, size = 10, sort = "registerTime", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponseDTO<StudentResponseDTO> page = studentService.getAllStudents(pageable);
        if (page.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudentById(@PathVariable UUID id, @RequestBody StudentUpdateDTO updatedStudentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(id, updatedStudentDto));
    }
    
    @PutMapping("/toggle/{id}")
    public ResponseEntity<Void> toggleStudentActiveById(@PathVariable UUID id) {
        studentService.toggleStudentActiveById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable UUID id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
