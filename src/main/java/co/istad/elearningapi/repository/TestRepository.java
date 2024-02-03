package co.istad.elearningapi.repository;

import co.istad.elearningapi.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TestRepository {

    private final List<Instructor> instructors;

    TestRepository() {
        instructors = new ArrayList<>();
        instructors.add(Instructor.builder()
                .id(1)
                .familyName("Chan")
                .givenName("Chhaya")
                .nationalIdCard("KHMER001")
                .build());
        instructors.add(Instructor.builder()
                .id(2)
                .familyName("Chan")
                .givenName("Dara")
                .nationalIdCard("KHMER002")
                .build());
        instructors.add(Instructor.builder()
                .id(3)
                .familyName("Kit")
                .givenName("Tara")
                .nationalIdCard("KHMER003")
                .build());
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public Integer getSize() {
        return instructors.size();
    }

    public Integer getLastId() {
        return instructors.get(getSize() - 1).getId();
    }
}
