package com.javatodev.api.controller;

import com.javatodev.api.model.request.Favourite;
import com.javatodev.api.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/favourite")
@CrossOrigin(origins = "http://localhost:3000")
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping
    public ResponseEntity<List<Favourite>> getPatientFavourites(@RequestParam String patientId) {
        List<Favourite> favourites = favouriteService.getPatientFavourites(patientId);
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Favourite> addFavourite(@RequestBody Favourite favourite) {
        Favourite addedFavourite = favouriteService.addFavourite(favourite);
        return new ResponseEntity<>(addedFavourite, HttpStatus.CREATED);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeFavourite(@RequestParam String id) {
        favouriteService.removeFavourite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
