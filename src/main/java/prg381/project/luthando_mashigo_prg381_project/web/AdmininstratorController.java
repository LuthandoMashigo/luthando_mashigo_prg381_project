package prg381.project.luthando_mashigo_prg381_project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import prg381.project.luthando_mashigo_prg381_project.model.Administrator;
import prg381.project.luthando_mashigo_prg381_project.service.AdminService;

@Controller
public class AdmininstratorController {

	@Autowired
    private AdminService adminService;

    @GetMapping("/AdminLogin") 
    public String AdminLogin() {
        return "AdminLogin";
    }

    @GetMapping("/admin/new")
	public String createAdminForm(Model model) {
		
		// create admin object to hold student form data
		Administrator administrator = new Administrator();
		model.addAttribute("administrator", administrator);
		return "AdminRegistration";
		
	}
	
	@PostMapping("/admins")
	public String saveAdmin(@ModelAttribute("administrator") Administrator administrator) {
		adminService.saveAdministrator(administrator);
		return "redirect:/AdminLogin";
	}
	
}
