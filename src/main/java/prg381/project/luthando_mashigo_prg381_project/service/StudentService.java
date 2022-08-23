package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import prg381.project.luthando_mashigo_prg381_project.model.Student;

public interface StudentService extends UserDetailsService{
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    Student updateStudent(Student student);
}
