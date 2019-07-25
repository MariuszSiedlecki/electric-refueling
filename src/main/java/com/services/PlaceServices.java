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
        mockPlaces();
    }

    private void mockPlaces() {
        placeRepository.save(Place
                .builder()
                .placeName("Ikea")
                .address("Josepha Conrada")
                .city("Cracow")
                .chargerType("EV")
                .image("image")
                .openingHours("24h")
                .placeInfo("gallery Bonarca")
                .build()
        );
    }

    public Place getPlaceByName(String placeName) {
        Optional<Place> result = placeRepository.findPlaceByName(placeName);
        if (result.isPresent()) {
            return placeRepository.findPlaceByName(placeName).get();
        }
        return null;

    }

    public Optional<Place> getOptionalPlaceByName(String placeName) {
        return Optional.of(placeRepository
                .findPlaceByName(placeName))
                .orElse(Optional.empty());
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

    public Place updatePlace(String placeName, Place place) {
        Optional<Place> result = placeRepository.findPlaceByName(placeName);
        if (result.isPresent()) {
            result.get().setPlaceName(place.getPlaceName());
            result.get().setAddress(place.getAddress());
            result.get().setChargerType(place.getChargerType());
            result.get().setCity(place.getCity());
            result.get().setOpeningHours(place.getOpeningHours());
            result.get().setImage(place.getImage());
            result.get().setPlaceInfo(place.getPlaceInfo());
            return placeRepository.save(result.get());
        }
        return null;
    }

    public boolean deletePlaceByName(String placeName) {
        return placeRepository.deletePlaceByName(placeName) == 1;
    }
}




