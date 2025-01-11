package com.exemplu.controller;

import jakarta.transaction.Transactional;
import org.springframework.ui.Model;
import com.exemplu.entity.Masina;
import com.exemplu.service.MasinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/masini")
public class MasinaController {
    private final MasinaService masinaService;

    @Autowired
    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }
    @GetMapping
    public String redirectToAfisare() {
        return "redirect:/masini/afisare";
    }
    @GetMapping("/afisare")
    public String afisareMasini(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String culoare,
            @RequestParam(required = false) String combustibil,
            Model model) {

        List<Masina> masini = (marca != null || culoare != null || combustibil != null)
                ? masinaService.getFilteredMasini(marca, culoare, combustibil)
                : masinaService.getAllMasini();
        model.addAttribute("masini",masini);
        return "masini";
    }
}
