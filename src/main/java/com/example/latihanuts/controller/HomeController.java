package com.example.latihanuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Alamat utama: http://localhost:8080/
    @GetMapping("/")
    public String homePage() {
        return "<!DOCTYPE html>" +
                "<html lang='id'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>Latihan UTS Spring Boot</title>" +
                "<link rel='stylesheet' href='/css/style.css'>" +
                "</head>" +
                "<body>" +
                "<main class='card'>" +
                "<span class='eyebrow'>SPRING BOOT PROJECT</span>" +
                "<h1>Selamat Datang!</h1>" +
                "<p class='intro'>Jelajahi kumpulan latihan UTS Spring Boot yang tersedia.</p>" +
                "<h2>Daftar Menu Latihan</h2>" +
                "<nav class='menu' aria-label='Daftar menu latihan'>" +
                "<a href='/john-travolta' class='menu-link'>" +
                "<span><strong>John Travolta Endpoint</strong><small>Pesan sambutan personal</small></span>" +
                "<span class='arrow' aria-hidden='true'>→</span>" +
                "</a>" +
                "<a href='/kuadrat?a=1&b=-3&c=2' class='menu-link'>" +
                "<span><strong>Persamaan Kuadrat</strong><small>Hitung akar-akar persamaan</small></span>" +
                "<span class='arrow' aria-hidden='true'>→</span>" +
                "</a>" +
                "</nav>" +
                "<p class='footer-note'>Semoga latihan UTS-nya lancar dan sukses! <span aria-hidden='true'>✨</span></p>" +
                "</main>" +
                "</body>" +
                "</html>";
    }
}