package br.futurodev.jmt.m2s08.controller;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import br.futurodev.jmt.m2s08.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cities")
public class CityController {

    private final CityService service;

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
