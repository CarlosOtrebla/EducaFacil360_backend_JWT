package com.otrebla.educa_facil_360.dto.Employee;

import com.otrebla.educa_facil_360.enums.PersonRoleENUM;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "O email é obrigatório")
    @Email
    private String email;
    
    @NotBlank(message = "O cpf é obrigatório")
    @CPF
    private String cpf;
    
    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}")
    private String phoneNumber;
    
    @NotBlank(message = "A senha é obrigatória")
    private String password;
    
    @Column(unique = true)
    private String username;
    
    private PersonRoleENUM role;


    
  
}
