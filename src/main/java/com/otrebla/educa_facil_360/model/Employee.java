package com.otrebla.educa_facil_360.model;

import com.otrebla.educa_facil_360.dto.Employee.EmployeeRequestDTO;
import com.otrebla.educa_facil_360.enums.PersonRoleENUM;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data // Gera os getters, setters, toString, equals e hashCode
@NoArgsConstructor // Gera o construtor padrão
@AllArgsConstructor // Gera o construtor com todos os atributos
@Builder // Permite o uso do padrão Builder
public class Employee extends Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(nullable = false)
    private String password;
    
    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private PersonRoleENUM role;

    @Column(nullable = false)
    private Boolean isDeleted;
    
    @ManyToMany
    @JoinTable(
            name = "classroom_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private Set<Classroom> classrooms;
    

    // Construtor que aceita EmployeeRequestDTO
    public Employee(EmployeeRequestDTO employeeRequestDto) {
        super(employeeRequestDto.getName(), employeeRequestDto.getEmail(), employeeRequestDto.getCpf(),
                employeeRequestDto.getPhoneNumber(), LocalDateTime.now(), true); // Ajuste os valores conforme necessário
        this.password = employeeRequestDto.getPassword();
        this.username = employeeRequestDto.getUsername();
        this.role = employeeRequestDto.getRole();
        this.isDeleted = false; // Ou outro valor padrão conforme sua lógica
        if(this.role == PersonRoleENUM.TEACHER) {
            this.classrooms = Set.of();
        }
    }

    // Sobrescrevendo métodos da interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return this.password; // Retorna o atributo password
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Define se a conta está expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Define se a conta está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Define se as credenciais estão expiradas
    }

    @Override
    public boolean isEnabled() {
        return !isDeleted; // Define se o usuário está ativo
    }
}
