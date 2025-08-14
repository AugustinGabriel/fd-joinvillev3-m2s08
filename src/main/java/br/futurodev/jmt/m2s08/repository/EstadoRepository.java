package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {
}
