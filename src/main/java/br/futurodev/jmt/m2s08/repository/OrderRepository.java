package br.futurodev.jmt.m2s08.repository;

import br.futurodev.jmt.m2s08.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
