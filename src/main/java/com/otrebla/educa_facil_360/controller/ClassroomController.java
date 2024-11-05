package com.otrebla.educa_facil_360.controller;


import com.otrebla.educa_facil_360.dto.Classrom.ClassroomRequestDTO;
import com.otrebla.educa_facil_360.dto.Classrom.ClassroomResponseDTO;
import com.otrebla.educa_facil_360.dto.PageResponseDTO;
import com.otrebla.educa_facil_360.dto.Student.StudentResponseDTO;
import com.otrebla.educa_facil_360.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    
    @Autowired
    private ClassroomService classroomService;
    
    // Endpoint para criar uma nova turma
    @PostMapping
    public ResponseEntity<ClassroomResponseDTO> createClassroom(@Valid @RequestBody ClassroomRequestDTO classroomRequest) {
        ClassroomResponseDTO createdClassroom = classroomService.createClassroom(classroomRequest);
        return ResponseEntity.ok(createdClassroom);
    }
   
    @GetMapping
    public ResponseEntity<PageResponseDTO<ClassroomResponseDTO>> getAllClassrooms(
            @PageableDefault(page = 0, size = 10, sort = "registerTime", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponseDTO<ClassroomResponseDTO> page = classroomService.getAllClassrooms(pageable);
        if (page.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }
   
}