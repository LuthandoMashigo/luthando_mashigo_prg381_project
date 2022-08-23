package prg381.project.luthando_mashigo_prg381_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prg381.project.luthando_mashigo_prg381_project.model.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator,Long> {
    Administrator findByEmail(String email);
}
