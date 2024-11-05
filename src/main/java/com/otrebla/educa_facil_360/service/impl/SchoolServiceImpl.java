package com.otrebla.educa_facil_360.service.impl;

import com.otrebla.educa_facil_360.dto.School.SchoolRequestDTO;
import com.otrebla.educa_facil_360.dto.School.SchoolResponseDTO;
import com.otrebla.educa_facil_360.model.School;
import com.otrebla.educa_facil_360.repository.SchoolRepository;
import com.otrebla.educa_facil_360.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {
    
    @Autowired
    private SchoolRepository schoolRepository;
    
    @Override
    public SchoolResponseDTO createSchool(SchoolRequestDTO schoolRequestDTO) {
        School school = new School();
        school.setName(schoolRequestDTO.getName());
        school.setPhoneNumber(schoolRequestDTO.getPhoneNumber());
        school.setEmail(schoolRequestDTO.getEmail());
        
        School savedSchool = schoolRepository.save(school);
        return new SchoolResponseDTO(savedSchool);
    }
    
    @Override
    public List<SchoolResponseDTO> getAllSchools() {
        return schoolRepository.findAll().stream()
                .map(SchoolResponseDTO::new)
                .collect(Collectors.toList());
    }
    
    @Override
    public SchoolResponseDTO getSchoolById(UUID id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id " + id));
        return new SchoolResponseDTO(school);
    }
    
    @Override
    public SchoolResponseDTO updateSchool(UUID id, SchoolRequestDTO schoolRequestDTO) {
        return schoolRepository.findById(id).map(school -> {
            school.setName(schoolRequestDTO.getName());
            school.setPhoneNumber(schoolRequestDTO.getPhoneNumber());
            school.setEmail(schoolRequestDTO.getEmail());
            School updatedSchool = schoolRepository.save(school);
            return new SchoolResponseDTO(updatedSchool);
        }).orElseThrow(() -> new RuntimeException("School not found with id " + id));
    }
    
    @Override
    public void deleteSchool(UUID id) {
        schoolRepository.deleteById(id);
    }
}
