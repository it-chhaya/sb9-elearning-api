package co.istad.elearningapi.repository;

import co.istad.elearningapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndIsDeletedAndIsVerified(String email, Boolean isDeleted, Boolean isVerified);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
