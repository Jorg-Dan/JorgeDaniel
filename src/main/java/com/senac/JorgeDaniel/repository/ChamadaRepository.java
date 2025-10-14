package com.senac.JorgeDaniel.repository;

import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.entity.Chamada;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Integer> {

    @Query("SELECT c FROM Chamada c WHERE c.status >=0")
    List<Chamada> listarChamadas();

    @Query("""
           SELECT c
           FROM Chamada c
           WHERE
                c.id+:id AND
                c.status>=0
           """)
    Chamada obterChamadaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Chamada c SET c.Status = -1 WHERE c.id = :id")
    int apagadoLogico(@Param("id")int id);

}
