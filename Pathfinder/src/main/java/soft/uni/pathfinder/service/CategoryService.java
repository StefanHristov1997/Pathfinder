package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.Category;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;

public interface CategoryService {
   Category getCategory(CategoryEnum category);
}
