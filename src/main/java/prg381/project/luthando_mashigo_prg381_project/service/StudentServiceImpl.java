package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import prg381.project.luthando_mashigo_prg381_project.model.Student;
import prg381.project.luthando_mashigo_prg381_project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl() {
    }

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
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    
}
