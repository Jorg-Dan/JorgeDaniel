package com.senac.JorgeDaniel.controller;

import com.senac.JorgeDaniel.dto.request.AtendenteDTORequest;
import com.senac.JorgeDaniel.dto.response.AtendenteDTOResponse;
import com.senac.JorgeDaniel.entity.Atendente;
import com.senac.JorgeDaniel.service.AtendenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/atendente")
@Tag(name = "Atendente", description = "API para gerenciamento de atendentes")
public class AtendenteController {

    private final AtendenteService atendenteService;

    public AtendenteController(AtendenteService atendenteService){
        this.atendenteService = atendenteService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar atendentes do sistema")
    public ResponseEntity<List<Atendente>> listar(){
        return ResponseEntity.ok(atendenteService.listarAtendentes());
    }

    @GetMapping("/listarPorIdAtendemte/{idAtendente}")
    @Operation(summary = "Listar atendentes por id")
    public ResponseEntity<Atendente> listarPorIdAtendente(@PathVariable("idAtendente") Integer idAtendente){
        Atendente atendente = atendenteService.listarAtendentesPorId(idAtendente);
        if (atendente == null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(atendente);
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<AtendenteDTOResponse> criar(@Valid @RequestBody AtendenteDTORequest atendenteDTORequest){
        return ResponseEntity.ok(atendenteService.atendenteCriar(atendenteDTORequest));
    }

    @PutMapping("/atualizar/{idAtendente}")
    @Operation(summary = "Atualizar dados um atendente")
    public ResponseEntity<AtendenteDTOResponse> atualizar(
            @Valid @PathVariable("idAtendente") Integer idAtendente,
            @RequestBody AtendenteDTORequest atendenteDTORequest){
        return ResponseEntity.ok(atendenteService.atualizar(idAtendente, atendenteDTORequest));
    }

    @DeleteMapping("/desligar/{idAtendente}")
    @Operation(summary = "Apagar atendente pelo idAtendente")
    public ResponseEntity<AtendenteDTOResponse> apagar(@PathVariable("idAtendente") Integer idAtendente){
        atendenteService.desligar(idAtendente);
        return ResponseEntity.noContent().build();
    }

}
