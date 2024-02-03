package co.istad.elearningapi.service;

import co.istad.elearningapi.dto.InstructorCreationDto;
import co.istad.elearningapi.dto.InstructorDto;
import co.istad.elearningapi.dto.InstructorEditionDto;
import co.istad.elearningapi.model.Instructor;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> search(String familyName,
                               String givenName,
                               String biography);

    InstructorDto findById(Integer id);

    void deleteById(Integer id);

    InstructorDto editById(Integer id, InstructorEditionDto instructorEditionDto);

    void createNew(InstructorCreationDto instructorCreationDto);

    InstructorDto findByIdAndNationalIdCard(Integer id,
                                            String nationalIdCard);

    List<InstructorDto> findList(String q);

}
