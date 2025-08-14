package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import br.futurodev.jmt.m2s08.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public List<CityEntity> get() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityEntity post(@RequestBody CityEntity city) {
        return service.save(city);
    }
}
