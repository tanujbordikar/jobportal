package com.dev.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.jobportal.dto.Users;
import com.dev.jobportal.dto.UsersType;
import com.dev.jobportal.service.UsersService;
import com.dev.jobportal.service.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model) {
    	Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
    	if(optionalUsers.isPresent()) {
    		model.addAttribute("error", "Email already registered, try to login or register with other email!");
    		List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
    	}
    	usersService.addNew(users);
    	return "redirect:/dashboard/";
    }
}