package com.services;

import com.models.Place;
import com.repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServices {

    private PlaceRepository placeRepository;

    public PlaceServices(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public Place getPlaceByName(String placeName) {
        return placeRepository.findPlaceByName(placeName).get();
    }
    public Optional<Place> getOptionalPlaceByName(String placeName){
        return Optional.of(placeRepository
                .findPlaceByName(placeName))
                .orElse(Optional.empty());
    }
    public List<Place> getPlaces(){
        return placeRepository.findAll();
    }
    public List<Place> getPlaces(String param){
        return placeRepository.findPlacesByParam(param);
    }
}





