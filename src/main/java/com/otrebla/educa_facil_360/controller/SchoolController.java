package com.otrebla.educa_facil_360.controller;

import com.otrebla.educa_facil_360.dto.School.SchoolRequestDTO;
import com.otrebla.educa_facil_360.dto.School.SchoolResponseDTO;
import com.otrebla.educa_facil_360.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    
    @Autowired
    private SchoolService schoolService;
    
    @PostMapping
    public ResponseEntity<SchoolResponseDTO> createSchool(@RequestBody SchoolRequestDTO schoolRequestDTO) {
        SchoolResponseDTO createdSchool = schoolService.createSchool(schoolRequestDTO);
        return ResponseEntity.ok(createdSchool);
    }
    
    @GetMapping
    public ResponseEntity<List<SchoolResponseDTO>> getAllSchools() {
        List<SchoolResponseDTO> schools = schoolService.getAllSchools();
        return ResponseEntity.ok(schools);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponseDTO> getSchoolById(@PathVariable UUID id) {
        try {
            SchoolResponseDTO school = schoolService.getSchoolById(id);
            return ResponseEntity.ok(school);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SchoolResponseDTO> updateSchool(
            @PathVariable UUID id, @RequestBody SchoolRequestDTO schoolRequestDTO) {
        try {
            SchoolResponseDTO updatedSchool = schoolService.updateSchool(id, schoolRequestDTO);
            return ResponseEntity.ok(updatedSchool);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable UUID id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }
}
