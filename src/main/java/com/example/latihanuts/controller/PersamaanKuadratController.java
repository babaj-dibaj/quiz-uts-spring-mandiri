package com.example.latihanuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersamaanKuadratController {

    // Alamat URL endpoint: http://localhost:8080/kuadrat
    @GetMapping("/kuadrat")
    public String hitungKuadrat(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b,
            @RequestParam(required = false) Double c) {
        String hasil = "";

        if (a != null && b != null && c != null) {
            if (a == 0) {
                hasil = "<div class='result error'><strong>Input tidak valid</strong>" +
                        "<span>Nilai <b>a</b> tidak boleh 0 karena ini bukan persamaan kuadrat.</span></div>";
            } else {
                hasil = buatHasil(a, b, c);
            }
        }

        return "<!DOCTYPE html>" +
                "<html lang='id'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>Kalkulator Persamaan Kuadrat</title>" +
                "<link rel='stylesheet' href='/css/style.css'>" +
                "</head>" +
                "<body>" +
                "<main class='card calculator-card'>" +
                "<a class='back-link' href='/'>← Kembali ke menu</a>" +
                "<span class='eyebrow'>MATH CALCULATOR</span>" +
                "<h1>Persamaan Kuadrat</h1>" +
                "<p class='intro'>Masukkan nilai koefisien untuk menghitung diskriminan dan akar-akar persamaan.</p>" +
                "<form class='quadratic-form' method='get' action='/kuadrat'>" +
                "<label for='a'>Nilai a<input id='a' name='a' type='number' step='any' required value='" +
                nilaiInput(a) + "'></label>" +
                "<label for='b'>Nilai b<input id='b' name='b' type='number' step='any' required value='" +
                nilaiInput(b) + "'></label>" +
                "<label for='c'>Nilai c<input id='c' name='c' type='number' step='any' required value='" +
                nilaiInput(c) + "'></label>" +
                "<button type='submit'>Hitung Sekarang <span aria-hidden='true'>→</span></button>" +
                "</form>" +
                hasil +
                "</main>" +
                "</body>" +
                "</html>";
    }

    private String nilaiInput(Double nilai) {
        return nilai == null ? "" : String.valueOf(nilai);
    }

    private String buatHasil(double a, double b, double c) {
        double diskriminan = (b * b) - (4 * a * c);
        String akar;

        if (diskriminan > 0) {
            double x1 = (-b + Math.sqrt(diskriminan)) / (2 * a);
            double x2 = (-b - Math.sqrt(diskriminan)) / (2 * a);
            akar = "<div class='root-grid'><div><small>Akar x1</small><strong>" + x1 +
                    "</strong></div><div><small>Akar x2</small><strong>" + x2 + "</strong></div></div>";
        } else if (diskriminan == 0) {
            double x = -b / (2 * a);
            akar = "<div class='root-grid'><div><small>Akar kembar</small><strong>x1 = x2 = " + x +
                    "</strong></div></div>";
        } else {
            double bagianReal = -b / (2 * a);
            double bagianImajiner = Math.sqrt(-diskriminan) / Math.abs(2 * a);
            akar = "<div class='root-grid'><div><small>Akar x1</small><strong>" + bagianReal + " + " +
                    bagianImajiner + "i</strong></div><div><small>Akar x2</small><strong>" + bagianReal +
                    " - " + bagianImajiner + "i</strong></div></div>";
        }

        return "<section class='result' aria-live='polite'>" +
                "<span class='result-label'>HASIL PERHITUNGAN</span>" +
                "<p class='equation'>" + a + "x² + " + b + "x + " + c + " = 0</p>" +
                "<div class='discriminant'><small>Diskriminan (D)</small><strong>" + diskriminan +
                "</strong></div>" + akar + "</section>";
    }
}