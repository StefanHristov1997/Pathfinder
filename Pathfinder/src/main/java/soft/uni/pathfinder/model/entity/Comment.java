package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
