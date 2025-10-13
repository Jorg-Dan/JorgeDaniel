package com.senac.JorgeDaniel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chamadas")
public class Chamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chamada_id")
    private int id;

}
