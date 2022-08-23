package prg381.project.luthando_mashigo_prg381_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import prg381.project.luthando_mashigo_prg381_project.model.Administrator;
import prg381.project.luthando_mashigo_prg381_project.service.AdminService;

@Controller
public class AdmininstratorController {

    private AdminService adminService;

    @GetMapping("/AdminLogin") 
    public String AdminLogin() {
        return "AdminLogin";
    }

    @GetMapping("/admin/new")
	public String createAdminForm(Model model) {
		
		// create student object to hold student form data
		Administrator student = new Administrator();
		model.addAttribute("student", student);
		return "AdminRegistration";
		
	}
	
	@PostMapping("/admins")
	public String saveStudent(@ModelAttribute("administrator") Administrator administrator) {
		adminService.save(administrator);
		return "redirect:/AdminLogin";
	}

}
