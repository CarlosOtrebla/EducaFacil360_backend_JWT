package com.otrebla.educa_facil_360.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class School {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Telefone não pode ser nulo ou vazio.")
    @Column(length = 100, unique = true)
    @Pattern(regexp = "^(\\([1-9]{2}\\))?\\s?(?:[1-9]|9[0-9])[0-9]{3}(?:-?[0-9]{4})$", message = "Telefone não está no padrão, tente no formato (xx) xxxxx-xxxx!")
    private String phoneNumber;
    
    @Column(nullable = false)
    @Email
    private String email;
    
    @ManyToMany
    @JoinTable(
            name = "school_employee",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

}
