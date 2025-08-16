package br.futurodev.jmt.m2s08.service;

import br.futurodev.jmt.m2s08.entity.CategoryEntity;
import br.futurodev.jmt.m2s08.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> categoryOpt = repository.findById(id);
        if (categoryOpt.isPresent()) {
            return categoryOpt.get();
        } else {
            return null;
        }
    }

    public CategoryEntity save(CategoryEntity category) {
        return repository.save(category);
    }

    public CategoryEntity update(Long id, CategoryEntity category) {
        CategoryEntity categoryFound = findById(id);
        if (categoryFound == null) {
            return null;
        }

        categoryFound.setName(category.getName());

        return repository.save(categoryFound);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
