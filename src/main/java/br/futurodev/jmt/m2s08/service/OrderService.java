package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> findAll();
    OrderEntity findById(Long id);
    OrderEntity save(OrderEntity order);

}
