package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CityEntity;
import br.futurodev.jmt.m2s08.repository.CityRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public List<CityEntity> findAll(String name, String estadoSigla) {
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(estadoSigla)) {
            return repository.findByNameOrEstadoSigla(name, estadoSigla);
        }
        if (StringUtils.isNotBlank(name)) {
            return repository.findByName(name);
        }
        if (StringUtils.isNotBlank(estadoSigla)) {
            return repository.findByEstadoSigla(estadoSigla);
        }
        return repository.findAll();
    }

    public CityEntity save(CityEntity cityEntity) {
        return repository.save(cityEntity);
    }

}
