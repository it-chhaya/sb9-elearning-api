package co.istad.elearningapi.repository;

import co.istad.elearningapi.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface InstructorRepository
        extends JpaRepository<Instructor, Integer> {

    Optional<Instructor> findByIdAndNationalIdCard(Integer id,
                                                   String nationalIdCard);

    List<Instructor> findByFamilyNameIgnoreCase(String familyName);

    List<Instructor> findByGivenNameIgnoreCase(String givenName);

    List<Instructor> findByBiographyContainsIgnoreCase(String biography);
}
