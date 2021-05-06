package com.bailram.restfullapi.controller;

import com.bailram.restfullapi.model.Mahasiswa;
import com.bailram.restfullapi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    @GetMapping("/")
    public List<Mahasiswa> findAll() {
        return mahasiswaService.findAll();
    }

    @GetMapping("/{nim}")
    public Mahasiswa findByNim(@PathVariable(value = "nim") int nim) {
        return mahasiswaService.findByNim(nim);
    }

    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.addMahasiswa(mahasiswa);
    }

    @PutMapping("/update/{nim}")
    public String updateMahasiswa(@PathVariable(value = "nim") int nim, @RequestBody Mahasiswa mahasiswa) {
        return mahasiswaService.updateMahasiswa(nim, mahasiswa);
    }

    @DeleteMapping("/delete/{nim}")
    public String deleteMahasiswa(@PathVariable(value = "nim") int nim) {
        return mahasiswaService.deleteMahasiswa(nim);
    }
}
