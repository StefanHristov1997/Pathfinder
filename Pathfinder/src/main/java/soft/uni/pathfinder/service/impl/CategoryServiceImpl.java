package soft.uni.pathfinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.repository.CategoryRepository;
import soft.uni.pathfinder.service.CategoryService;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Set<CategoryEntity> getAllByNameIn(Set<CategoryEnum> categories) {
        return this.categoryRepository.findAllByNameIn(categories);
    }
}
