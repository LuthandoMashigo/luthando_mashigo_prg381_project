package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prg381.project.luthando_mashigo_prg381_project.model.Role_Student;
import prg381.project.luthando_mashigo_prg381_project.model.Student;
import prg381.project.luthando_mashigo_prg381_project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }



    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {

        Student student2 = new Student(student.getStudent_name(), 
        student.getStudent_address(), student.getEmail(), student.getStudent_password(), Arrays.asList(new Role_Student("ROLE_STUDENT")));

        return studentRepository.save(student2);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    
}
