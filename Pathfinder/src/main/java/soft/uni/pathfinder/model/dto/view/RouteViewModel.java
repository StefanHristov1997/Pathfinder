package soft.uni.pathfinder.model.dto.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteViewModel {
    private Long id;
    private String name;
    private String videoUrl;
    private String description;
    private String level;
    private String authorName;
}
