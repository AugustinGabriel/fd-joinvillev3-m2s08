package br.futurodev.jmt.m2s08.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estados")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 2)
    private String sigla;

}

/*
CREATE TABLE estados(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(20) NOT NULL,
	sigla VARCHAR(2) NOT NULL
);
 */
