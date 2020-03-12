package springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springBoot.model.Role;
import springBoot.model.User;
import springBoot.service.RoleService;
import springBoot.service.UserService;

import java.beans.PropertyEditorSupport;
import java.util.List;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @PostMapping("/saveUser")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @InitBinder                                         //запускаеи блок initBinder для обработки списка прав
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, "roles", new PropertyEditorSupport() {          //переводим String id в Role
            @Override
            public void setAsText(String text) {
                setValue(roleService.getRoleById(new Integer(text)));
            }
        });
    }
}
