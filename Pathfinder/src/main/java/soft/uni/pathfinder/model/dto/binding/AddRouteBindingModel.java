package soft.uni.pathfinder.model.dto.binding;

import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

@Getter
@Setter
public class AddRouteBindingModel {

    private LevelEnum level;

    private String name;

    private String videoUrl;

    private String description;

    private Set<CategoryEnum> categories;
}
