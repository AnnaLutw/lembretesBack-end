package com.dti.projeto.lembrete;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
//Classe Lembrete recebendo o nome da tabela do banco de dados que irá receber seus dados
//Utilizando biblioteca lombok para diminuir o codigo adicionando contrutores e getters apenas com a notação

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name ="lembretestable")
@Entity(name =" Lembrete")
public class Lembrete {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String nome;

    public Lembrete(DadosLembrete dados) {
        this.data = dados.data();
        this.nome = dados.nome();
    }
}
