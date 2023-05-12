package com.dti.projeto.controller;

import com.dti.projeto.lembrete.DadosLembrete;
import com.dti.projeto.service.LembreteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
* Classe Controller onde a requisição criada irá passar gerando respostas
*
* */

//Notações para identificar a classe como um Controller e seu mapeamento
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    //atributo LembreteService para chamar os metodos
    @Autowired
    private LembreteService service;

    //Método para adicionar um lembrete salvando os dados em um metodo service e deixando uma notação Post
    @Transactional
    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void adicionaLembrete(@RequestBody @Valid DadosLembrete dados){
        service.save(dados);
    }

    //Método para deletar um lembrete pelo id, chamando um metodo service onde tem a regra para deletar
    @DeleteMapping(value="/{idLembrete}")
    public  void deleteLembrete(@PathVariable("idLembrete") @Valid Long idLembrete){
        service.delete(idLembrete);
    }

    //Método para pegar um lembrete pelo id, chamando um metodo service  onde tem a regra para buscar esse id
    @GetMapping(value="/{idLembrete}")
    public  void findById(@PathVariable("idLembrete") @Valid Long idLembrete){
        service.findById(idLembrete);
    }

    //Método onde devolve todos os lembretes em uma lista, chamando um metodo service
    @CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "Requestor-Type")
    @GetMapping(value="/")
    public List<DadosLembrete> findAll(){
        return service.findAll();
    }
}
