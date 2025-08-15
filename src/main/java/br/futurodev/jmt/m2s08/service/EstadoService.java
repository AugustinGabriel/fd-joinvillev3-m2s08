package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.EstadoEntity;

import java.util.List;

public interface EstadoService {

    List<EstadoEntity> findAll();
    EstadoEntity findById(Long id);
    EstadoEntity save(EstadoEntity estado);
    EstadoEntity update(Long id, EstadoEntity estado);
    void delete(Long id);

}
