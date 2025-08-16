package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.MaterialEntity;
import br.futurodev.jmt.m2s08.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("materials")
public class MaterialController {

    private final MaterialService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // -> Status 201
    public MaterialEntity post(@RequestBody MaterialEntity material) {
        return service.save(material);
    }

    @GetMapping
    public List<MaterialEntity> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public MaterialEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public MaterialEntity put(@PathVariable Long id, @RequestBody MaterialEntity material) {
        return service.update(id, material);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // -> Status 204
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
