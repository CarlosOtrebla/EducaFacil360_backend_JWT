package com.otrebla.educa_facil_360.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@MappedSuperclass
@Data // Gera os getters, setters, toString, equals e hashCode automaticamente
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
public abstract class Person {
    
    @NotBlank(message = "Nome não pode ser nulo ou vazio.")
    @Size(max = 150, message = "O Nome não pode ter mais de 150 caracteres.")
    @Size(min = 2, message = "O Nome não pode ter menos de 2 caracteres.")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(unique = true, nullable = false)
    private String email;
    
    @CPF(message = "CPF deve ser válido")
    @Column(unique = true, nullable = false)
    private String cpf;
    
    @NotBlank(message = "Telefone não pode ser nulo ou vazio.")
    @Column(length = 100, unique = true)
    @Pattern(regexp = "^(\\([1-9]{2}\\))?\\s?(?:[1-9]|9[0-9])[0-9]{3}(?:-?[0-9]{4})$", message = "Telefone não está no padrão, tente no formato (xx) xxxxx-xxxx!")
    private String phoneNumber;
    
    private LocalDateTime registerTime;
    private Boolean active;
}
