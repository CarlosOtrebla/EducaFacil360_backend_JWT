package com.otrebla.educa_facil_360.dto.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data // Gera getters e setters automaticamente
@NoArgsConstructor // Construtor padrão
@AllArgsConstructor // Construtor com todos os argumentos
public class StudentRequestDTO {
    
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
    
//    private PersonRole role;
    

}
