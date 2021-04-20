package com.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Scanner;

@Controller
public class SalaryController {

    @GetMapping
    public String getForm() {
        return "form";
    }

    @PostMapping
    public String updateUser(
            @RequestParam(value = "usd") Double usd,
            @RequestParam(value = "curs") Double curs,
            Model model) {
        double sal = usd * curs;
        if (sal > 7000) sal = ((sal - 7000) * 0.75) + 7000;
        model.addAttribute("salary", sal);
        return "salary";
    }


}