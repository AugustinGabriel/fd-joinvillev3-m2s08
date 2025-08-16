package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.OrderEntity;
import br.futurodev.jmt.m2s08.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    public List<OrderEntity> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public OrderEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity post(@RequestBody OrderEntity order) {
        return service.save(order);
    }

}
