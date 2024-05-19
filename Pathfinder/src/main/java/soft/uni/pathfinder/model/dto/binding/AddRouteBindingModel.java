package soft.uni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

@Getter
@Setter
public class AddRouteBindingModel {

    @NotNull
    private LevelEnum level;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String videoUrl;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Set<CategoryEnum> categories;
}
