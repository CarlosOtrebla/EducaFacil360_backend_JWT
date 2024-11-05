package com.otrebla.educa_facil_360.service;

import com.otrebla.educa_facil_360.dto.School.SchoolRequestDTO;
import com.otrebla.educa_facil_360.dto.School.SchoolResponseDTO;
import java.util.List;
import java.util.UUID;

public interface SchoolService {
    SchoolResponseDTO createSchool(SchoolRequestDTO schoolRequestDTO);
    List<SchoolResponseDTO> getAllSchools();
    SchoolResponseDTO getSchoolById(UUID id);
    SchoolResponseDTO updateSchool(UUID id, SchoolRequestDTO schoolRequestDTO);
    void deleteSchool(UUID id);
}
