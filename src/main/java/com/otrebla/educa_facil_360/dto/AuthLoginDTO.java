package com.otrebla.educa_facil_360.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthLoginDTO {
    String email;
    String password;
    
    public AuthLoginDTO() {
    }
    
    public AuthLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
}


