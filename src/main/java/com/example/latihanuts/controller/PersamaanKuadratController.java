package com.example.latihanuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersamaanKuadratController {

    // Alamat URL endpoint: http://localhost:8080/kuadrat?a=1&b=-3&c=2
    @GetMapping("/kuadrat")
    public String hitungKuadrat(@RequestParam double a, @RequestParam double b, @RequestParam double c) {
        if (a == 0) {
            return "Nilai 'a' tidak boleh 0 karena ini bukan persamaan kuadrat!";
        }

        double diskriminan = (b * b) - (4 * a * c);
        String hasil;

        if (diskriminan > 0) {
            double x1 = (-b + Math.sqrt(diskriminan)) / (2 * a);
            double x2 = (-b - Math.sqrt(diskriminan)) / (2 * a);
            hasil = "Akar-akar real berbeda: x1 = " + x1 + " dan x2 = " + x2;
        } else if (diskriminan == 0) {
            double x = -b / (2 * a);
            hasil = "Akar kembar: x1 = x2 = " + x;
        } else {
            hasil = "Akar imajiner (negatif dalam diskriminan).";
        }

        return "Persamaan: " + a + "x^2 + " + b + "x + " + c + " = 0<br>" +
                "Diskriminan (D): " + diskriminan + "<br>" +
                "Hasil: " + hasil;
    }
}