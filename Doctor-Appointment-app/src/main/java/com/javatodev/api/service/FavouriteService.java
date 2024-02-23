package com.javatodev.api.service;

import com.javatodev.api.model.request.Favourite;
import com.javatodev.api.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavouriteService {

    private final FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteService(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    public List<Favourite> getPatientFavourites(String patientId) {
        return favouriteRepository.findByPatientId(patientId);
    }

    public Favourite addFavourite(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    public void removeFavourite(String id) {
        favouriteRepository.deleteById(id);
    }
}
