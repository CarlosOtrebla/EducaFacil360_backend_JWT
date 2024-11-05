package com.otrebla.educa_facil_360.dto.School;

import com.otrebla.educa_facil_360.dto.Classrom.ClassroomResponseDTO;
import com.otrebla.educa_facil_360.model.Employee;
import com.otrebla.educa_facil_360.model.School;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class SchoolResponseDTO {
    
    private UUID id;
    private String name;
    private String phoneNumber;
    @Email
    private String email;
    private List<ClassroomResponseDTO> classrooms;
    private List<Employee> teachers;
    
    public SchoolResponseDTO() {
        // Inicializa a lista de turmas como uma lista vazia para evitar NullPointerException
        this.classrooms = new ArrayList<>();
    }
    
    public SchoolResponseDTO(UUID id, String name, String phoneNumber, String email, List<ClassroomResponseDTO> classrooms, List<Employee> teachers) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classrooms = classrooms;
        this.teachers = teachers;
    }
    
    public SchoolResponseDTO(School savedSchool) {
    }
}
