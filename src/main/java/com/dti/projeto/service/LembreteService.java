package com.dti.projeto.service;
import com.dti.projeto.lembrete.DadosLembrete;
import java.util.List;

//Interface para serem implementadas as regras dee negocio em outra classe
public interface LembreteService {

    //Método para salvar
    void save(DadosLembrete dados);

    //Método para deletar um lembrete por id
    void delete(Long idLembrete);

    //Método para encontrar todos os lembretes
    List<DadosLembrete> findAll();

    //Método para encontrar apenas um lembrete por id
    DadosLembrete findById(Long idLembrete);
}
