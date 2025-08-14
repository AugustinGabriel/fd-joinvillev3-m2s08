package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.EstadoEntity;
import br.futurodev.jmt.m2s08.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estados")
public class EstadoController {

    @Autowired
    private EstadoService service;

    /*
C    @PostMapping
R    @GetMapping
R    @GetMapping("{id}")
U    @PutMapping("{id}")
D    @DeleteMapping("{id}")
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // -> Status 201
    public EstadoEntity post(@RequestBody EstadoEntity estado) {
        return service.save(estado);
    }

    @GetMapping
    public List<EstadoEntity> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public EstadoEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public EstadoEntity put(@PathVariable Long id, @RequestBody EstadoEntity estado) {
        return service.update(id, estado);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // -> Status 204
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
