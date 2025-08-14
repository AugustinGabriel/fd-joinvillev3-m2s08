package br.futurodev.jmt.m2s08.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 10)
    private String code;

}

/*
CREATE TABLE cities(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	code VARCHAR(10)
);
 */
