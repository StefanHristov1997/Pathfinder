package soft.uni.pathfinder.model.dto.view;

import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

@Getter
@Setter
public class ProfileViewModel {

      private LevelEnum level;

      private String fullName;

      private String username;
}
