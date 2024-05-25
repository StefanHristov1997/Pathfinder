package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureService {
    Optional<List<Picture>> findPictureByRouteId(Long id);
}
