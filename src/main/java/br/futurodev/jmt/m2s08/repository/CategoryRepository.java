package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
