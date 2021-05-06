package com.bailram.restfullapi.repository;

import com.bailram.restfullapi.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
    Mahasiswa findByNim(int nim);
}
