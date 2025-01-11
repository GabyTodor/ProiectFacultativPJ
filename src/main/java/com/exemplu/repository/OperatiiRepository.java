package com.exemplu.repository;

import com.exemplu.entity.Masina;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatiiRepository extends JpaRepository<Masina, String> {
        Masina findByNrInmatriculare(String nrInmatriculare);
        @Transactional
        void deleteByNrInmatriculare(String nrInmatriculare);
}
