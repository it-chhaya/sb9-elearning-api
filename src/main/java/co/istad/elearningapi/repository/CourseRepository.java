package co.istad.elearningapi.repository;

import co.istad.elearningapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends
        JpaRepository<Course, Long> {
}
