package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.Categories;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Categories name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

}
