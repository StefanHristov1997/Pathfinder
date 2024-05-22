package soft.uni.pathfinder.service;

import soft.uni.pathfinder.model.entity.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> findPictureByRouteId(Long id);
}
