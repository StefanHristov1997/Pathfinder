package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.Role;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;

import java.util.Set;

public interface RoleService {
    Set<Role> findByRoleName(UserRoleEnum roleName);
}
