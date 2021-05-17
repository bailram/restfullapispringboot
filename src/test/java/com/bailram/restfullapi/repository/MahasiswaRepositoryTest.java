package com.bailram.restfullapi.repository;

import com.bailram.restfullapi.model.Mahasiswa;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MahasiswaRepositoryTest {

    @Autowired
    private MahasiswaRepository underTest;

    @Test
    void findByNim_shouldSuccess() {
        // given
        Mahasiswa mahasiswa = new Mahasiswa(1,"Test", "test jurusan", 4.0f);
        underTest.save(mahasiswa);
        // when
        Mahasiswa result = underTest.findByNim(1);
        // then
        assertThat(result).isNotNull();
    }

    @Test
    void findByNim_shouldFail() {
        // given
        Mahasiswa mahasiswa = new Mahasiswa(2,"Test", "test jurusan", 4.0f);
        underTest.save(mahasiswa);
        // when
        Mahasiswa result = underTest.findByNim(3);
        // then
        assertThat(result).isNull();
    }
}