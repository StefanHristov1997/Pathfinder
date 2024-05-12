package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.UserRoles;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private UserRoles name;
}
