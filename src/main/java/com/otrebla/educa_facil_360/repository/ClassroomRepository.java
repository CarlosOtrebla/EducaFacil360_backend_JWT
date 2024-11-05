package com.otrebla.educa_facil_360.repository;

import com.otrebla.educa_facil_360.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {
    // Podemos adicionar métodos customizados, caso necessário, como busca por atributos específicos
}
