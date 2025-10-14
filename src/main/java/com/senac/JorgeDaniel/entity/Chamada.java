package com.senac.JorgeDaniel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamadas")
public class Chamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chamada_id")
    private int id;
    @Column(name = "chamada_descricao")
    private String descricao;
    @Column(name = "chamada_abertura")
    private LocalDateTime abertura;
    @Column(name = "chamada_fechamento")
    private LocalDateTime fechamento;
    @Column(name = "chamada_status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "atendente_id", nullable = false)
    @JsonIgnore
    private Atendente atendente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDateTime abertura) {
        this.abertura = abertura;
    }

    public LocalDateTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDateTime fechamento) {
        this.fechamento = fechamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
}
