package prg381.project.luthando_mashigo_prg381_project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import prg381.project.luthando_mashigo_prg381_project.model.Administrator;

public interface AdminService extends UserDetailsService{
    Administrator save(Administrator administrator);
}
