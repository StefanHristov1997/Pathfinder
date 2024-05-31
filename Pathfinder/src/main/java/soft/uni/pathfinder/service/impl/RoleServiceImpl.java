package soft.uni.pathfinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.entity.RoleEntity;
import soft.uni.pathfinder.model.entity.enums.UserRoleEnum;
import soft.uni.pathfinder.repository.RoleRepository;
import soft.uni.pathfinder.service.RoleService;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity findRoleNyName(String roleName) {
        return this.roleRepository.findRoleEntityByName(UserRoleEnum.valueOf(roleName));
    }
}
