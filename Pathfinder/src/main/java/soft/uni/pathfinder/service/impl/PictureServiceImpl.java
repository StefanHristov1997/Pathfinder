package soft.uni.pathfinder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.uni.pathfinder.model.entity.Picture;
import soft.uni.pathfinder.repository.PictureRepository;
import soft.uni.pathfinder.service.PictureService;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<Picture> findPictureByRouteId(Long id) {
        return this.pictureRepository.findPictureByRouteId(id);
    }
}
