package com.senac.JorgeDaniel.repository;

import com.senac.JorgeDaniel.entity.Atendente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {
    List<Atendente> listarAtendentesAtivos();

    @Query("""
            SELECT a
            FROM Atendente a
            WHERE
                a.id=:id AND
                a.status>=0
            """)
    Atendente obterAtendentePorId(@Param("id")int id);

    @Modifying
    @Transactional
    @Query("UPDATE Atendente a SET a.status = -1 WHERE a.id = :id")
    int atendenteDesligado(@Param("id") int id);

    Optional<Atendente> findByLogin(String login);
}
