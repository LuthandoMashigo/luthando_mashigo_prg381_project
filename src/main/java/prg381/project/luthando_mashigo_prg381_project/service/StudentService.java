package prg381.project.luthando_mashigo_prg381_project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import prg381.project.luthando_mashigo_prg381_project.model.Student;

public interface StudentService  extends UserDetailsService{
    Student save(StudentRegistrationDto registrationDto);

    void deleteStudentById(long id);

    Student getStudentById(long id);
}
