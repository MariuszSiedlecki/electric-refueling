package com.services;

import com.models.Place;
import com.repositories.PlaceRepository;
import org.springframework.http.ResponseEntity;
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
        return Optional
                .ofNullable(placeRepository.findPlaceByName(placeName))
                .map(this::placeNameToUpperCase)
                .orElse(null);
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public List<Place> getPlaces(String param) {
        return placeRepository.findPlacesByParam(param);
    }

    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(String placeName, Place place){
        return Optional.ofNullable(placeRepository.findPlaceByName(placeName))
                .map(p-> {
                    p.setPlaceName(place.getPlaceName());
                    p.setPlaceInfo(place.getPlaceInfo());
                    p.setOpeningHours(place.getOpeningHours());
                    p.setChargerType(place.getChargerType());
                    p.setCity(place.getCity()) ;
                    p.setAddress(place.getAddress());
                    p.setImage(place.getImage());

                    return savePlace(p);
                })
                .map(this::placeNameToUpperCase)
                .orElse(null);
    }

    public boolean deletePlaceByName(String placeName) {
        return placeRepository.deletePlaceByName(placeName) == 1;
    }


    private Place placeNameToUpperCase(Place place){
        place.setPlaceName(place.getPlaceName().toUpperCase());
        return place;
    }

    private Place updatePlaceResult(Place place){
        return Place
                .builder()
                .id(place.getId())
                .placeName(place.getPlaceName())
                .placeInfo(place.getPlaceInfo())
                .openingHours(place.getOpeningHours())
                .chargerType(place.getChargerType())
                .city(place.getCity())
                .address(place.getAddress())
                .image(place.getImage())
                .build();
    }
}




