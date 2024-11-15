package com.otrebla.educa_facil_360.controller;


import com.otrebla.educa_facil_360.dto.AuthDTO;
import com.otrebla.educa_facil_360.dto.TokenDTO;
import com.otrebla.educa_facil_360.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000/login") // Adiciona CORS diretamente aqui
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public TokenDTO login(@RequestBody AuthDTO authDTO){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password());
        Authentication auth =  authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken(auth.getName());
        return new TokenDTO(token, auth.getName());
    }
}
