package com.example.latihanuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JohnTravoltaController {

    // Alamat URL endpoint: http://localhost:8080/john-travolta
    @GetMapping("/john-travolta")
    public String getJohnTravoltaMessage(@RequestParam(value = "name", defaultValue = "Pengguna") String name) {
        return "Halo " + name + "! Selamat datang di tugas UTS Spring Boot ala John Travolta! 🕺✨";
    }
}