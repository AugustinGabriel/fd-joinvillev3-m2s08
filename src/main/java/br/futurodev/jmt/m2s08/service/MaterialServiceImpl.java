package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.MaterialEntity;
import br.futurodev.jmt.m2s08.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    public List<MaterialEntity> findAll() {
        return repository.findAll();
    }

    public MaterialEntity findById(Long id) {
        Optional<MaterialEntity> materialOpt = repository.findById(id);
        if (materialOpt.isPresent()) {
            return materialOpt.get();
        } else {
            return null;
        }
    }

    public MaterialEntity save(MaterialEntity material) {
        return repository.save(material);
    }

    public MaterialEntity update(Long id, MaterialEntity material) {
        MaterialEntity materialFound = findById(id);
        if (materialFound == null) {
            return null;
        }

        materialFound.setName(material.getName());
        materialFound.setDescription(material.getDescription());

        return repository.save(materialFound);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
