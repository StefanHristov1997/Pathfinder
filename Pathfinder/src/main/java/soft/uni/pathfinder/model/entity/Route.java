package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.Levels;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(name = "gpx_coordinates", nullable = false, columnDefinition = "TEXT")
    private String gpxCoordinates;

    @Enumerated(value = EnumType.STRING)
    private Levels level;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> category;
}
