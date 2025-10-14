package com.senac.JorgeDaniel.controller;

import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.entity.Chamada;
import com.senac.JorgeDaniel.service.AtendenteService;
import com.senac.JorgeDaniel.service.ChamadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/chamadas")
@Tag(name="Chamada", description="API para gerenciamento de chamadas do sistema")
public class ChamadaController {
    private final ChamadaService chamadaService;
    private final AtendenteService atendenteService;

    public ChamadaController(ChamadaService chamadaService, AtendenteService atendenteService){
        this.chamadaService = chamadaService;
        this.atendenteService = atendenteService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar chamadas do sistema")
    public ResponseEntity<List<Chamada>> listar(){
        return ResponseEntity.ok(chamadaService.listarChamadas());
    }

    @GetMapping("/listarPorIdchamada/{idChamada}")
    @Operation(summary = "Listar chamadas do sistema pelo id da chamada")
    public ResponseEntity<Chamada> listarPorIdchamada(@PathVariable("idChamada") Integer idChamada){
        Chamada chamada = chamadaService.listarChamadaPorId(idChamada);
        if (chamada == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(chamada);
        }
    }

    @GetMapping("/listarPorIdAtendente/{idAtendente}")
    @Operation(summary = "Listar chamadas do sistema pelo id do atendente")
    public ResponseEntity<Atendente> listarPorIdAtendente(@PathVariable("idAtendente") Integer idAtendente){
        Atendente chamada = atendenteService.listarAtendentesPorId(idAtendente);
        if (chamada == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(chamada);
        }
    }

}
