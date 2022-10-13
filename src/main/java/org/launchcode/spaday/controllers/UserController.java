package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
            }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verifyPassword) {
        if (errors.hasErrors() || !user.getPassword().equals(verifyPassword)) {
           return "user/add";
        }
        else {
            return "user/index";
        }
    }


}
