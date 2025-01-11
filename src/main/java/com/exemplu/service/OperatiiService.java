package com.exemplu.service;

import com.exemplu.entity.Masina;
import com.exemplu.repository.OperatiiRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatiiService {
    @Autowired
    private OperatiiRepository repository;

    // Găsirea tuturor mașinilor
    public List<Masina> gasesteToateMasinile() {
        return repository.findAll();
    }

    // Adăugare mașină
    public void adaugaMasina(Masina masina) {
        repository.save(masina);
    }

    // Modificare mașină
    @Transactional
    public void modificaMasina(Masina masina) {
        Masina masinaExistenta = repository.findByNrInmatriculare(masina.getNrInmatriculare());
        if (masinaExistenta != null) {
            if (masina.getMarca() != null && !masina.getMarca().isEmpty()) {
                masinaExistenta.setMarca(masina.getMarca());
            }
            if (masina.getModel() != null && !masina.getModel().isEmpty()) {
                masinaExistenta.setModel(masina.getModel());
            }
            if (masina.getCuloare() != null && !masina.getCuloare().isEmpty()) {
                masinaExistenta.setCuloare(masina.getCuloare());
            }
            if (masina.getAnFabricatie() != null) { // Verifică pentru null
                masinaExistenta.setAnFabricatie(masina.getAnFabricatie());
            }
            if (masina.getCapacitateCilindrica() != null) { // Verifică pentru null
                masinaExistenta.setCapacitateCilindrica(masina.getCapacitateCilindrica());
            }
            if (masina.getCombustibil() != null && !masina.getCombustibil().isEmpty()) {
                masinaExistenta.setCombustibil(masina.getCombustibil());
            }
            if (masina.getPutere() != null) { // Verifică pentru null
                masinaExistenta.setPutere(masina.getPutere());
            }
            if (masina.getCuplu() != null) { // Verifică pentru null
                masinaExistenta.setCuplu(masina.getCuplu());
            }
            if (masina.getVolumPortbagaj() != null) { // Verifică pentru null
                masinaExistenta.setVolumPortbagaj(masina.getVolumPortbagaj());
            }
            if (masina.getPret() != null) { // Verifică pentru null
                masinaExistenta.setPret(masina.getPret());
            }
            repository.save(masinaExistenta);
        }
    }


    // Ștergere mașină
    @Transactional
    public void stergeMasina(String nrInmatriculare) {
        repository.deleteByNrInmatriculare(nrInmatriculare);
    }
}
