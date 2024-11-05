package com.otrebla.educa_facil_360.service;

import com.otrebla.educa_facil_360.dto.AuthLoginDTO;
import com.otrebla.educa_facil_360.dto.Employee.EmployeeResponseDTO;
import com.otrebla.educa_facil_360.exception.NotValidUserException;
import com.otrebla.educa_facil_360.model.Employee;
import com.otrebla.educa_facil_360.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthenticationService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public EmployeeResponseDTO login(AuthLoginDTO request)throws NotValidUserException {
        Optional<Employee> employeeOpt = employeeRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if(employeeOpt.isEmpty()) throw new NotValidUserException("User or password incorrect");
        return new EmployeeResponseDTO(employeeOpt.get());
    }
}
