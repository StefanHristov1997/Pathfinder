package soft.uni.pathfinder.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.UserRole;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private UserRole name;
}
