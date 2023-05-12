package com.dti.projeto.lembrete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.Date;

//Classe record para descrever os dados de um lembrete,
public record DadosLembrete(
        //Atributos de um lembrete
        Long id,

        //validando os atributos para não serem nulos
        @NotNull(message = "O campo data não pode estar vazio")
        Date data,
        @NotBlank(message = "O campo nome não pode estar vazio")
        String nome) {

}
