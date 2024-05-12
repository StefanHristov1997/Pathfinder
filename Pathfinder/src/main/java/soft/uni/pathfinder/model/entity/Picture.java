package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
