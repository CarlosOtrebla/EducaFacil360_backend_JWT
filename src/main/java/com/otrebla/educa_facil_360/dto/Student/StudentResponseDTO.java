package com.otrebla.educa_facil_360.dto.Student;
import com.otrebla.educa_facil_360.enums.PersonRoleENUM;
import com.otrebla.educa_facil_360.model.Student;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StudentResponseDTO {
    private UUID id;
    private PersonRoleENUM role;
    private String name;
    private String email;
    private String cpf;
    private String phoneNumber;
    private LocalDateTime registerTime;
    private Boolean active;
    
    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.cpf = student.getCpf();
        this.phoneNumber = student.getPhoneNumber();
        this.registerTime = student.getRegisterTime();
        this.active = student.getActive();
        this.role = student.getRole();
    }
    
  
}
