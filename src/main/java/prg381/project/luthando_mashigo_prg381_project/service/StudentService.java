package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import prg381.project.luthando_mashigo_prg381_project.model.Student;

public interface StudentService  extends UserDetailsService{
    Student save(Student student);

    List<Student> getAllStudents();
    void deleteStudentById(long id);

    Student getStudentById(long id);
}
