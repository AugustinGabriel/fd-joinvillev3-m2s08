package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.EstadoEntity;
import br.futurodev.jmt.m2s08.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<EstadoEntity> findAll() {
        return repository.findAll();
    }

    public EstadoEntity findById(Long id) {
        Optional<EstadoEntity> estadoOpt = repository.findById(id);
        if (estadoOpt.isPresent()) {
            return estadoOpt.get();
        } else {
            return null;
        }
    }

    public EstadoEntity save(EstadoEntity estado) {
        return repository.save(estado);
    }

    public EstadoEntity update(Long id, EstadoEntity estado) {
        EstadoEntity estadoEncontrado = findById(id);
        if (estadoEncontrado == null) {
            return null;
        }

        estadoEncontrado.setNome(estado.getNome());
        estadoEncontrado.setSigla(estado.getSigla());

        return repository.save(estadoEncontrado);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
