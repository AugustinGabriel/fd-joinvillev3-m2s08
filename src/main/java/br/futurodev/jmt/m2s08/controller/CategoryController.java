package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.CategoryEntity;
import br.futurodev.jmt.m2s08.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // -> Status 201
    public CategoryEntity post(@RequestBody CategoryEntity category) {
        return service.save(category);
    }

    @GetMapping
    public List<CategoryEntity> get() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CategoryEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("{id}")
    public CategoryEntity put(@PathVariable Long id, @RequestBody CategoryEntity category) {
        return service.update(id, category);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // -> Status 204
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
