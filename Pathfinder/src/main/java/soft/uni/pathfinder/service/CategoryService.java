package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.CategoryEntity;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;

public interface CategoryService {
   CategoryEntity getCategory(CategoryEnum category);
}
