package com.exemplu.controller;

import jakarta.transaction.Transactional;
import org.springframework.ui.Model;
import com.exemplu.entity.Masina;
import com.exemplu.service.OperatiiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operatii")
public class OperatiiController {
    @Autowired
    private OperatiiService service;

    // Afișare listă mașini
    @GetMapping
    public String afisareMasini(Model model) {
        model.addAttribute("masini", service.gasesteToateMasinile());
        return "operatii";
    }

    // Adăugare mașină
    @PostMapping("/adauga")
    public String adaugaMasina(@ModelAttribute Masina masina) {
        service.adaugaMasina(masina);
        return "redirect:/operatii";
    }

    // Modificare mașină
    @PostMapping("/modifica")
    public String modificaMasina(@ModelAttribute Masina masina) {
        service.modificaMasina(masina);
        return "redirect:/operatii";
    }

    // Ștergere mașină
    @PostMapping("/sterge")
    public String stergeMasina(@RequestParam String nrInmatriculare) {
        service.stergeMasina(nrInmatriculare);
        return "redirect:/operatii";
    }
}
