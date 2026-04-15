package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private User dataUser; // temporary (tidak pakai database)

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

        // GANTI PASSWORD DENGAN NIM KAMU
        if (username.equals("admin") && password.equals("123456")) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Login gagal!");
            return "login";
        }
    }

    // ================= HOME =================
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("data", dataUser);
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
        this.dataUser = user;
        return "redirect:/home";
    }
}