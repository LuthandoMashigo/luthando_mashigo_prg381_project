package prg381.project.luthando_mashigo_prg381_project.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import prg381.project.luthando_mashigo_prg381_project.model.Administrator;
import prg381.project.luthando_mashigo_prg381_project.model.Role_Admin;
import prg381.project.luthando_mashigo_prg381_project.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {


    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        super();
        this.adminRepository = adminRepository;
    }

     //This for encyrpting passwords and is neccessary for Spring Security to function
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Administrator saveAdministrator(Administrator administrator) {
            Administrator administrator2 = new Administrator(administrator.getAdmin_name(),
             administrator.getEmail(), 
            passwordEncoder.encode(administrator.getPassword()), 
            administrator.getContact(), Arrays.asList(new Role_Admin("ROLE_ADMIN")));

            return adminRepository.save(administrator2);
    }

    //Mapping user defined admin roles to the authority class from srping security in order for login to function
    private Collection<? extends GrantedAuthority> mapRoleAuthorities(Collection<Role_Admin> adminrole){
        return adminrole.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Administrator administrator = adminRepository.findByEmail(username);
       if (administrator == null) {
            throw new UsernameNotFoundException("Invalid Admin credentials");
       } 

       return  new org.springframework.security.core.userdetails.User(administrator.getEmail(),administrator.getPassword(),mapRoleAuthorities(administrator.getRole_admin()));
    }
    

}
