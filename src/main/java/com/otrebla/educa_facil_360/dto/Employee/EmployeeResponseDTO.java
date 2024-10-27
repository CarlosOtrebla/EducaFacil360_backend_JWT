package com.otrebla.educa_facil_360.dto.Employee;

import com.otrebla.educa_facil_360.enums.PersonRole;
import com.otrebla.educa_facil_360.model.Employee;
import com.otrebla.educa_facil_360.model.Student;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EmployeeResponseDTO {
    private UUID id;
    private PersonRole role;
    private String name;
    private String email;
    private String cpf;
    private String phoneNumber;
    private LocalDateTime registerTime;
    private Boolean active;
    
    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.cpf = employee.getCpf();
        this.phoneNumber = employee.getPhoneNumber();
        this.registerTime = employee.getRegisterTime();
        this.active = employee.getActive();
        this.role = employee.getRole();
    }
}
