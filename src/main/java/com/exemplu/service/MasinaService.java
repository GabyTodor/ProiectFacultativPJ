package com.exemplu.service;

import com.exemplu.entity.Masina;
import com.exemplu.repository.MasinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasinaService {
    private final MasinaRepository masinaRepository;

    @Autowired
    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public List<Masina> getFilteredMasini(String marca, String culoare, String combustibil){
        return masinaRepository.findByMarcaContainingAndCuloareContainingAndCombustibilContaining
                (marca != null ? marca : "", culoare != null ? culoare : "", combustibil != null ? combustibil : "");
    }

    public List<Masina> getAllMasini() {
        return masinaRepository.findAll();
    }
}
