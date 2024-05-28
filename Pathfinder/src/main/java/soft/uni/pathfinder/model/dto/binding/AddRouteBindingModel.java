package soft.uni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

@Getter
@Setter
public class AddRouteBindingModel {

    @NotBlank
    @Length(min = 3, message = "Name should be with more than 3 characters.")
    private String name;

    @NotNull(message = "Required field")
    private LevelEnum level;

    @NotBlank(message = "Required field")
    @Length(min = 11, max = 11, message = "VideoURL should be with 11 symbols.")
    private String videoUrl;

    @NotBlank
    @Length(min = 5, message = "Description should be with more than 5 characters.")
    private String description;

    @NotNull(message = "Required field")
    private Set<CategoryEnum> categories;
}
