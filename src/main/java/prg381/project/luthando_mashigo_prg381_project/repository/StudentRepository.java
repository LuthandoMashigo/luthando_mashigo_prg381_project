package prg381.project.luthando_mashigo_prg381_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prg381.project.luthando_mashigo_prg381_project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    Student findByEmail(String email);
}
