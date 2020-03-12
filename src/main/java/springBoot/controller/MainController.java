package springBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springBoot.model.User;
import springBoot.service.RoleService;
import springBoot.service.UserService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping
    public String common(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getRoles());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userCurent", user);
        return "common";
    }
}
