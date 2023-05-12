package com.dti.projeto.service.impl;

import com.dti.projeto.lembrete.DadosLembrete;
import com.dti.projeto.lembrete.Lembrete;
import com.dti.projeto.lembrete.LembreteRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;


@SpringBootTest
class LembreteServiceImplTest {

    @InjectMocks
    private LembreteServiceImpl serviceImpl;
    @Mock
    private LembreteRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveTest() {
        Date data = new Date();
        data.setTime(data.getTime() + 3600);
        DadosLembrete lembrete = new DadosLembrete(2L, data, "teste" );

        serviceImpl.save(lembrete);
        Mockito.verify(repository, atLeast(1)).save(any());
    }

    @Test
    void deleteTest() {
       serviceImpl.delete(2L);
       Mockito.verify(repository, atLeast(1)).deleteById(2L);
    }

    @Test
    void findAllTest() {
        Lembrete lembrete = new Lembrete();

        lembrete.setNome("teste");
        lembrete.setId(1L);
        lembrete.setData(new Date());
        Lembrete lembrete2 = new Lembrete();
        lembrete2.setNome("testeDois");
        lembrete2.setId(2L);
        lembrete2.setData(new Date());

        List<Lembrete> lista = new ArrayList<>();
        lista.add(lembrete);
        lista.add(lembrete2);

        Mockito.when(repository.findByOrderByDataAsc()).thenReturn(lista);
        List listaTeste = serviceImpl.findAll();
        Assertions.assertEquals(2, listaTeste.size());

    }

    @Test
    void findByIdTest() {
        Lembrete lembrete = new Lembrete();
        lembrete.setNome("teste");
        lembrete.setId(1L);
        lembrete.setData(new Date());
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(lembrete));
        DadosLembrete dadosLembrete = serviceImpl.findById(1L);
        Assertions.assertEquals(1L, dadosLembrete.id());
    }
}