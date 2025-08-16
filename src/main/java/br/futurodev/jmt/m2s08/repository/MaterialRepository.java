package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
}
