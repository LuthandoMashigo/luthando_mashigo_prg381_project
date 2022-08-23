package prg381.project.luthando_mashigo_prg381_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prg381.project.luthando_mashigo_prg381_project.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
