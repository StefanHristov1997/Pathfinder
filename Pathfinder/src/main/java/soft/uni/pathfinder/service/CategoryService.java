package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;

import java.util.Set;

public interface CategoryService {
   Set<CategoryEntity> getAllByNameIn(Set<CategoryEnum> category);
}
