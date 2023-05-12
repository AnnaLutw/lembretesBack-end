package com.dti.projeto.lembrete;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//Interface que extends a Jpa para implementar os metodos necessarios
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

    //Metodo para encontrar os lembretes na lista ja ordenados
    List<Lembrete> findByOrderByDataAsc();
}
