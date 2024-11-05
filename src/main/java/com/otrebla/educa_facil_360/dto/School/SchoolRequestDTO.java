package com.otrebla.educa_facil_360.dto.School;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequestDTO {
 
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "O telefone é obrigatório")
    private String phoneNumber;
    
    @NotBlank(message = "O email é obrigatório")
    private String email;
    
    
   
    
    
}
