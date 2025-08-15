package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import br.futurodev.jmt.m2s08.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public List<CityEntity> findAll() {
        return repository.findAll();
    }

    public CityEntity save(CityEntity cityEntity) {
        return repository.save(cityEntity);
    }

}
