//package com.otrebla.educa_facil_360.repository;
//
//import com.otrebla.educa_facil_360.model.Employee;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
//
//    Optional<Employee> findByUsername(String username);
//
//    @Query(value = "SELECT * FROM employee WHERE email = :email " +
//            "AND password = :password " +
//            "AND is_deleted = false " +
//            "AND active = true", nativeQuery = true)
//    Optional<Employee> findByEmailAndPassword(String email, String password);
//
//    Optional<Employee> findByEmail(String email);
//
//    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE LOWER(CONCAT('%', :search, '%')) AND is_deleted = false", nativeQuery = true)
//    Page<Employee> findAllNonDeletedByName(String search, Pageable pageable);
//
//    @Query(value = "SELECT * FROM employee WHERE is_deleted = false", nativeQuery = true)
//    Page<Employee> findAllNonDeleted(Pageable pageable);
//
//    @Query(value = "SELECT * FROM employee WHERE id = :id AND is_deleted = false", nativeQuery = true)
//    Optional<Employee> findNonDeletedById(UUID id);
//}

package com.otrebla.educa_facil_360.repository;

import com.otrebla.educa_facil_360.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Optional<Employee> findByUsername(String username);

    @Query(value = "SELECT * FROM employee WHERE email = :email " +
        "AND password = :password " +
        "AND is_deleted = false " +
        "AND active = true", nativeQuery = true)
    Optional<Employee> findByEmailAndPassword(String email, String password);

    Optional<Employee> findByEmail(String email);

    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE LOWER(CONCAT('%', :search, '%')) AND is_deleted = false", nativeQuery = true)
    Page<Employee> findAllNonDeletedByName(String search, Pageable pageable);

    @Query(value = "SELECT * FROM employee WHERE is_deleted = false", nativeQuery = true)
    Page<Employee> findAllNonDeleted(Pageable pageable);

    @Query(value = "SELECT * FROM employee WHERE id = :id AND is_deleted = false", nativeQuery = true)
    Optional<Employee> findNonDeletedById(UUID id);

    // Verificar a existência de CPF
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM employee WHERE cpf = :cpf", nativeQuery = true)
    boolean existsByCpf(String cpf);

    // Verificar a existência de e-mail
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM employee WHERE email = :email", nativeQuery = true)
    boolean existsByEmail(String email);

    // Verificar existência de username
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM employee WHERE username = :username", nativeQuery = true)
    boolean existsByUsername(String username);

    // Verificar existência de phoneNumber
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM employee WHERE phone_number = :phoneNumber", nativeQuery = true)
    boolean existsByPhoneNumber(String phoneNumber);





}
