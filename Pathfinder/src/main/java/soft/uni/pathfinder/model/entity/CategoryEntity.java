package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.CategoryEnum;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

}
