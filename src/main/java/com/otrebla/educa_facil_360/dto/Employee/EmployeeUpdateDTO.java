package com.otrebla.educa_facil_360.dto.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class EmployeeUpdateDTO {
    private String name;
    private String email;
    private String cpf;
    private String phoneNumber;
    private String password;
    private List<UUID> classrooms; // IDs das salas para atualização de associação
    
    // Construtor com parâmetros
    public EmployeeUpdateDTO(String name, String email, String cpf, String phoneNumber, String password, List<UUID> classrooms) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.classrooms = classrooms;
    }
}
