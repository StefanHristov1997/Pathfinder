package soft.uni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soft.uni.pathfinder.model.entity.enums.LevelEnum;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity author;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(name = "routes_categories" , joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<CategoryEntity> categories;

    public RouteEntity(){
        this.categories = new HashSet<>();
    }
}

