package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.Level;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true)
    private String email;

    @OneToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Set<Role> roles;

    @Enumerated (value = EnumType.STRING)
    @Column
    private Level level;

    public User() {
        this.roles = new HashSet<>();
    }
}

