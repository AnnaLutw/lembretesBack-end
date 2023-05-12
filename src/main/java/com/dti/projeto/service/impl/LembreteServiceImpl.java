package com.dti.projeto.service.impl;

import com.dti.projeto.exception.LembreteException;
import com.dti.projeto.lembrete.DadosLembrete;
import com.dti.projeto.lembrete.Lembrete;
import com.dti.projeto.lembrete.LembreteRepository;
import com.dti.projeto.service.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//Classe Service para implementar todas as regras de negocio e serem chamadas no controler
@Service
public class LembreteServiceImpl implements LembreteService {

    //Attibuto do tipo repository
    @Autowired
    private LembreteRepository repository;

    /*Método onde estou verificando se a data é futura e intanciando um lembrete com os dados recebidos caso
    * a verificação for verdadeira, se for falsa devolvo uma exceção
    * */
    @Override
    public void save(DadosLembrete dados){
        if (dados.data().compareTo(new Date()) <= 0){
            throw new LembreteException("Data deve estar no futuro!");
        }
        repository.save(new Lembrete(dados));
    }

    ///Método que utiliza o metodo deleteById do repository para deletar de forma mais simples
    public  void delete(Long idLembrete){

        repository.deleteById(idLembrete);
    }
    /*Método para listar todos os lembretes usando o stream e map para mapearem os dados e instanciando
    * um DadosLembretes para cada lembrete encontrado, fazendo uma lista com o metodo collect.
    * */
    @Override
    public List<DadosLembrete> findAll() {
        return repository.findByOrderByDataAsc().stream().map(item -> new DadosLembrete(item.getId(), item.getData(), item.getNome())).collect(Collectors.toList());
    }

    /*Método para encontrar algum lembrete pelo id mapeando os dados e instanciando
     * um DadosLembretes para o primeiro lembrete encontrado com aquele id.
     * */
    @Override
    public DadosLembrete findById(Long idLembrete) {
        return repository.findById(idLembrete).stream().map(item -> new DadosLembrete(item.getId(), item.getData(), item.getNome())).findFirst().get();
    }

}
