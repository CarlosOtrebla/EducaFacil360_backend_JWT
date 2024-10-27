package com.otrebla.educa_facil_360.dto.Employee;

import lombok.Data;

@Data
public class EmployeeUpdateDTO {
    private String name;
    private String email;
    private String cpf;
    private String phoneNumber;
    private String password; // Se você também quiser permitir a atualização da senha
    
    // Construtor padrão (opcional se você quiser usar o @NoArgsConstructor do Lombok)
    public EmployeeUpdateDTO() {
    }
    
    // Construtor com parâmetros (opcional)
    public EmployeeUpdateDTO(String name, String email, String cpf, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
