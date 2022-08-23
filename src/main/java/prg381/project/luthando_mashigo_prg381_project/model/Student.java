package prg381.project.luthando_mashigo_prg381_project.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_address")
    private String student_address;

    @Column(name = "email")
    private String email;

    @Column(name = "student_password")
    private String password;

    //Students can be have diffrent roles and a role can be handle by multiple students 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_roles",
        joinColumns = @JoinColumn(
            name = "student_student_id", referencedColumnName = "student_id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_student_id", referencedColumnName = "id"))

    private Collection<Role_Student> role_student;
    
    
    public Student() {
    }
    
    public Student(String student_name, String student_address, String email, String password,
            Collection<Role_Student> role_student) {
        this.student_name = student_name;
        this.student_address = student_address;
        this.email = email;
        this.password = password;
        this.role_student = role_student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role_Student> getRole_student() {
        return role_student;
    }

    public void setRole_student(Collection<Role_Student> role_student) {
        this.role_student = role_student;
    }
}
