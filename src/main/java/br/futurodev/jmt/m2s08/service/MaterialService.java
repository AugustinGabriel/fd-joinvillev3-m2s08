package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.MaterialEntity;

import java.util.List;

public interface MaterialService {

    List<MaterialEntity> findAll();
    MaterialEntity findById(Long id);
    MaterialEntity save(MaterialEntity material);
    MaterialEntity update(Long id, MaterialEntity material);
    void delete(Long id);

}
