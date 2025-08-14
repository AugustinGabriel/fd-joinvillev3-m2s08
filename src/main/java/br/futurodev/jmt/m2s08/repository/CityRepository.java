package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
