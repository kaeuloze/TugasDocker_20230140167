package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private List<User> dataList = new ArrayList<>();

    // ================= LOGIN =================
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        if (username.equals("admin") && password.equals("20230140167")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Login gagal!");
            return "login";
        }
    }

    // ================= HOME =================
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dataList", dataList);
        return "home";
    }

    // ================= FORM =================
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String submit(@ModelAttribute User user) {
        dataList.add(user);
        return "redirect:/home";
    }
}