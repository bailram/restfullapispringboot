package com.bailram.restfullapi.service;

import com.bailram.restfullapi.model.Mahasiswa;
import com.bailram.restfullapi.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> findAll() {
        return mahasiswaRepository.findAll();
    }

    public Mahasiswa findByNim(int nim){
        return mahasiswaRepository.findByNim(nim);
    }

    public String addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
        return "Successfully Add Mahasiswa";
    }

    public String updateMahasiswa(int nim, Mahasiswa mahasiswa) {
        Mahasiswa existMahasiswa = mahasiswaRepository.findByNim(nim);
        if (existMahasiswa == null) {
            return "Mahasiswa with NIM "+nim+" Not Found!";
        }
        if (!mahasiswa.getNama().isEmpty()) {
            existMahasiswa.setNama(mahasiswa.getNama());
        }
        if (!mahasiswa.getJurusan().isEmpty()) {
            existMahasiswa.setJurusan(mahasiswa.getJurusan());
        }
        if (mahasiswa.getIpk() != 0.0f) {
            existMahasiswa.setIpk(mahasiswa.getIpk());
        }
        mahasiswaRepository.save(existMahasiswa);
        return "Successfully update Mahasiswa with NIM "+nim;
    }

    public String deleteMahasiswa(int nim) {
        Mahasiswa existMahasiswa = mahasiswaRepository.findByNim(nim);
        if (existMahasiswa == null) {
            return "Mahasiswa with NIM "+nim+" Not Found!";
        }
        mahasiswaRepository.deleteById(nim);

        return "Successfully delete Mahasiswa with NIM "+nim;
    }
}
