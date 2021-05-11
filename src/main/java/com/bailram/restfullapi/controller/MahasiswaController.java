package com.bailram.restfullapi.controller;

import com.bailram.restfullapi.model.Mahasiswa;
import com.bailram.restfullapi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    @GetMapping("/")
    public ResponseEntity<List<Mahasiswa>> findAll() {
        List<Mahasiswa> result = mahasiswaService.findAll();
        if (result != null && !result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{nim}")
    public ResponseEntity<Mahasiswa> findByNim(@PathVariable(value = "nim") int nim) {
        Mahasiswa result = mahasiswaService.findByNim(nim);
        if (result != null || result.getNim() != 0) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.addMahasiswa(mahasiswa);
    }

    @PutMapping("/update/{nim}")
    public ResponseEntity<String> updateMahasiswa(@PathVariable(value = "nim") int nim, @RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.updateMahasiswa(nim, mahasiswa);
    }

    @DeleteMapping("/delete/{nim}")
    public ResponseEntity<String> deleteMahasiswa(@PathVariable(value = "nim") int nim) {
        return mahasiswaService.deleteMahasiswa(nim);
    }
}
