package com.exemplu.repository;

import com.exemplu.entity.Masina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasinaRepository extends JpaRepository<Masina, String> {
    List<Masina> findByMarcaContainingAndCuloareContainingAndCombustibilContaining(String marca, String culoare, String combustibil);
}
