package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();
    CategoryEntity findById(Long id);
    CategoryEntity save(CategoryEntity category);
    CategoryEntity update(Long id, CategoryEntity category);
    void delete(Long id);

}
