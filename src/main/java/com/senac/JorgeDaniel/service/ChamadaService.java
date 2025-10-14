package com.senac.JorgeDaniel.service;

import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.entity.Chamada;
import com.senac.JorgeDaniel.repository.AtendenteRepository;
import com.senac.JorgeDaniel.repository.ChamadaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadaService {

    private final ChamadaRepository chamadaRepository;

    public ChamadaService(ChamadaRepository chamadaRepository){
        this.chamadaRepository = chamadaRepository;
    }

    public List<Chamada> listarChamadas(){
        return this.chamadaRepository.findAll();
    }

    public Chamada listarChamadaPorId(int idChamada){
        return this.chamadaRepository.findById(idChamada).orElse(null);
    }

}
