package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import prg381.project.luthando_mashigo_prg381_project.model.Register;
import prg381.project.luthando_mashigo_prg381_project.model.Role_Student;
import prg381.project.luthando_mashigo_prg381_project.model.Student;
import prg381.project.luthando_mashigo_prg381_project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    
    private StudentRepository studentRepository;

    //This for encyrpting passwords and is neccessary for Spring Security to function
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
        student.getStudent_address(), student.getEmail(),
         passwordEncoder.encode(student.getStudent_password()), Arrays.asList(new Role_Student("ROLE_STUDENT")),Arrays.asList(new Register("PRG381")));

        return studentRepository.save(student2);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    //Mapping user defined student roles to the authority class from srping security in order for login to function
    private Collection<? extends GrantedAuthority> mapRoleAuthorities(Collection<Role_Student> studrole){
        return studrole.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username);
        if (student == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(student.getEmail(),student.getStudent_password(),mapRoleAuthorities(student.getRole_student()));
    }
    
    
}
