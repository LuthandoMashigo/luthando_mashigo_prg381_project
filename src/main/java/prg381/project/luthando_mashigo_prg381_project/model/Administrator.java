package prg381.project.luthando_mashigo_prg381_project.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "administrator",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long admin_id;

    @Column(name = "admin_name")
    private String admin_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contact")
    private String contact;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "admin_role",
        joinColumns = @JoinColumn(
            name = "administrator_admin_id", referencedColumnName = "admin_id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_admin_id", referencedColumnName = "id"))

    private Collection<Role_Admin> role_admin;

    

    public Administrator() {
        
    }

    public Administrator(String admin_name, String email, String password, String contact,
            Collection<Role_Admin> role_admin) {
        this.admin_name = admin_name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.role_admin = role_admin;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Collection<Role_Admin> getRole_admin() {
        return role_admin;
    }

    public void setRole_admin(Collection<Role_Admin> role_admin) {
        this.role_admin = role_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
