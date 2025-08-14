package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import br.futurodev.jmt.m2s08.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<CityEntity> findAll() {
        return repository.findAll();
    }

    public CityEntity save(CityEntity cityEntity) {
        return repository.save(cityEntity);
    }

}
