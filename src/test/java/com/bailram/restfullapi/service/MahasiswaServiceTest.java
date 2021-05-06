package com.bailram.restfullapi.service;

import com.bailram.restfullapi.model.Mahasiswa;
import com.bailram.restfullapi.repository.MahasiswaRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class MahasiswaServiceTest {

    @Autowired private MahasiswaService mahasiswaService;

    @MockBean
    @Autowired private MahasiswaRepository mahasiswaRepository;

    @Before
    public void init() {

    }

    @Test
    void findAll_shouldSuccess() {
        // given
        // when
        mahasiswaService.findAll();
        // then
        Mockito.verify(mahasiswaRepository, times(1)).findAll();
    }

    @Test
    void findByNim_shouldSuccess() {
        // given
        // when
        mahasiswaService.findByNim(anyInt());
        // then
        Mockito.verify(mahasiswaRepository, times(1)).findByNim(anyInt());
    }

    @Test
    void addMahasiswa_shouldSuccess(){
        // given
        // when
        Mahasiswa mahasiswa = new Mahasiswa(
                "Tes",
                "TesJurusan",
                4.0f
        );
        mahasiswaService.addMahasiswa(mahasiswa);
        // then
        Mockito.verify(mahasiswaRepository, times(1)).save(any());
    }

    @Test
    void updateMahasiswa_shouldSuccess(){
        // given
        final Mahasiswa mahasiswa = new Mahasiswa(1, "tes", "tesJurusan", 4.0f);
        Mockito.when(mahasiswaRepository.findByNim(1)).thenReturn(mahasiswa);
        // when
        Mahasiswa newMahasiswa = new Mahasiswa("TEs", "Jurusan", 1.0f);
        mahasiswaService.updateMahasiswa(1, newMahasiswa);
        // then
        Mockito.verify(mahasiswaRepository, times(1)).save(any());
    }

    @Test
    void updateMahasiswa_shouldFail(){
        // given
        Mockito.when(mahasiswaRepository.findByNim(1)).thenReturn(null);
        // when
        // then
        assertThat(mahasiswaService.updateMahasiswa(1, any()))
                .isEqualTo("Mahasiswa with NIM 1 Not Found!");
    }

    @Test
    void deleteMahasiswa_shouldSuccess(){
        // given
        final Mahasiswa mahasiswa = new Mahasiswa(1, "tes", "tesJurusan", 4.0f);
        Mockito.when(mahasiswaRepository.findByNim(1)).thenReturn(mahasiswa);
        // when
        mahasiswaService.deleteMahasiswa(mahasiswa.getNim());
        //then
        Mockito.verify(mahasiswaRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteMahasiswa_shouldFail(){
        // given
        Mockito.when(mahasiswaRepository.findByNim(anyInt())).thenReturn(null);
        // when
        //then
        assertThat(mahasiswaService.deleteMahasiswa(1))
                .isEqualTo("Mahasiswa with NIM 1 Not Found!");
    }


}