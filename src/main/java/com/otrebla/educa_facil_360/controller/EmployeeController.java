package com.otrebla.educa_facil_360.controller;

import com.otrebla.educa_facil_360.dto.PageResponseDTO;
import com.otrebla.educa_facil_360.dto.Employee.EmployeeRequestDTO;
import com.otrebla.educa_facil_360.dto.Employee.EmployeeResponseDTO;
import com.otrebla.educa_facil_360.dto.Employee.EmployeeUpdateDTO;
import com.otrebla.educa_facil_360.service.EmployeeService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO savedEmployee = employeeService.saveEmployee(employeeRequestDTO);
        
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        
        return ResponseEntity.created(uri).body(savedEmployee);
    }
    
    @GetMapping("/search")
    public ResponseEntity<PageResponseDTO<EmployeeResponseDTO>> getAllEmployeesBySearch(
            @RequestParam("field") String field,
            @RequestParam("search") String search,
            @PageableDefault(page = 0, size = 10, sort = "registerTime", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponseDTO<EmployeeResponseDTO> page = employeeService.getAllByFieldSearch(field, search, pageable);
        if (page.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }
    
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PageResponseDTO<EmployeeResponseDTO>> getAllEmployees(
            @PageableDefault(page = 0, size = 10, sort = "registerTime", direction = Sort.Direction.DESC) Pageable pageable) {
        PageResponseDTO<EmployeeResponseDTO> page = employeeService.getAllEmployees(pageable);
        if (page.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable UUID id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployeeById(@PathVariable UUID id, @RequestBody EmployeeUpdateDTO updatedEmployeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, updatedEmployeeDto));
    }
    
    @PutMapping("/toggle/{id}")
    public ResponseEntity<Void> toggleEmployeeActiveById(@PathVariable UUID id) {
        employeeService.toggleEmployeeActiveById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable UUID id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/upload-photo")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SCHOOL_PRINCIPAL') or hasAuthority('TEACHER') ")
    public ResponseEntity<String> uploadPhoto(@PathVariable UUID id, @RequestParam("photo") MultipartFile photo) throws IOException {
        // Busca o Employee pelo ID
        EmployeeResponseDTO employee = employeeService.getEmployeeById(id);

        // Salva a foto no banco
        employeeService.saveEmployeePhoto(id, photo.getBytes());

        return ResponseEntity.ok("Foto salva com sucesso!");
    }


}
