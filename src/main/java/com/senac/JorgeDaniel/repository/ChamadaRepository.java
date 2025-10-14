package com.senac.JorgeDaniel.repository;

import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.entity.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Integer> {

    @Query("SELECT a FROM Atendente a WHERE a.status >=0")
    List<Atendente> listarAtendentes();

}
