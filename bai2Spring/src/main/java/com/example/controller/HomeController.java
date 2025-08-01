package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
    public String home() {
        // Redirect to the tasks list page
        return "redirect:/tasks";
    }
}
