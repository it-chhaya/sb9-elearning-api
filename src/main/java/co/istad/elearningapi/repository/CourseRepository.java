package co.istad.elearningapi.repository;

import co.istad.elearningapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends
        JpaRepository<Course, Long> {

    List<Course> findAllByIsDeletedFalse();
    List<Course> findAllByIsDeletedTrue();

    Optional<Course> findByIdAndIsDeleted(Long id, Boolean isDeleted);

    boolean existsByIdAndIsDeletedFalse(Long id);

    @Modifying
    @Query("""
        UPDATE Course AS c
        SET c.isDeleted = TRUE
        WHERE c.id = ?1
    """)
    void updateIsDeletedById(Long id);

}
