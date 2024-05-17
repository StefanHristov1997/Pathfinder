package soft.uni.pathfinder.model.dto;

import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

@Getter
@Setter
public class AddRouteDTO {

    private LevelEnum level;

    private String name;

    private String videoUrl;

    private String description;

    private Set<CategoryEnum> categories;
}
