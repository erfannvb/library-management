package nvb.springframework.librarymanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String showMyLoginPage() {
        return "login";
    }

    @RequestMapping("/index")
    public String showMustGoOn() {
        return "index";
    }

    @PostMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
