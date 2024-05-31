package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.RoleEntity;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;

import java.util.Set;

public interface RoleService {
    RoleEntity findRoleNyName(String roleName);
}
