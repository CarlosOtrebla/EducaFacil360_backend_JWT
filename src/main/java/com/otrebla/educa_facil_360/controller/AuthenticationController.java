package com.otrebla.educa_facil_360.controller;

import com.otrebla.educa_facil_360.dto.AuthLoginDTO;
import com.otrebla.educa_facil_360.dto.Employee.EmployeeResponseDTO;
import com.otrebla.educa_facil_360.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/login")
    public ResponseEntity<EmployeeResponseDTO> login(@RequestBody AuthLoginDTO request) {
        EmployeeResponseDTO employeeResponseDTO = authenticationService.login(request);
        return ResponseEntity.ok(employeeResponseDTO);
    }
}
