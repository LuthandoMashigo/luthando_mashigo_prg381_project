package prg381.project.luthando_mashigo_prg381_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdmininstratorController {
    @GetMapping("/AdminLogin") 
    public String AdminLogin() {
        return "AdminLogin";
    }

    @PostMapping("/AdminLogin")
    public String registerAdministrator() {
        return "redirect:/AdminView"; 
    }
}
