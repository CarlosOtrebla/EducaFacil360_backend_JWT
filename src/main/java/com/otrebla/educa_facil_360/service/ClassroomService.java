package com.otrebla.educa_facil_360.service;

import com.otrebla.educa_facil_360.dto.Classrom.ClassroomRequestDTO;
import com.otrebla.educa_facil_360.dto.Classrom.ClassroomResponseDTO;
import com.otrebla.educa_facil_360.dto.PageResponseDTO;
import org.springframework.data.domain.Pageable;

public interface ClassroomService {
    
    ClassroomResponseDTO createClassroom(ClassroomRequestDTO classroomRequestDTO);
    
    PageResponseDTO<ClassroomResponseDTO> getAllClassrooms(Pageable pageable);

}