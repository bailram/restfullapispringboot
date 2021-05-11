package com.bailram.restfullapi.service;

import com.bailram.restfullapi.model.Mahasiswa;
import com.bailram.restfullapi.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<String> addMahasiswa(Mahasiswa mahasiswa) {
        try {
            mahasiswaRepository.save(mahasiswa);
            return new ResponseEntity<>("Successfully Add Mahasiswa", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Error occured: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateMahasiswa(int nim, Mahasiswa mahasiswa) {
        try {
            Mahasiswa existMahasiswa = mahasiswaRepository.findByNim(nim);
            if (existMahasiswa == null) {
                return new ResponseEntity<>("Mahasiswa with NIM "+nim+" Not Found!", HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>("Successfully update Mahasiswa with NIM "+nim, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occured: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteMahasiswa(int nim) {
        try {
            Mahasiswa existMahasiswa = mahasiswaRepository.findByNim(nim);
            if (existMahasiswa == null) {
                return new ResponseEntity<>("Mahasiswa with NIM "+nim+" Not Found!", HttpStatus.NOT_FOUND);
            }
            mahasiswaRepository.deleteById(nim);

            return new ResponseEntity<>("Successfully delete Mahasiswa with NIM "+nim, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Error occured: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
