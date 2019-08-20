package com.services;

import com.commons.extras.CreatorXls;
import com.commons.mappers.PlaceMapper;
import com.models.Place;
import com.models.PlaceDto;
import com.repositories.PlaceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;
    private PlaceMapper placeMapper;

    public PlaceService(PlaceRepository placeRepository, PlaceMapper placeMapper) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
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

    public List<PlaceDto> getPlacesDto() {
        return placeRepository
                .findAll()
                .stream()
                .map(placeMapper::map)
                .collect(Collectors.toList());
    }

    public List<Place> getPlaces(String param) {
        return placeRepository.findPlacesByParam(param);
    }

    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(String placeName, Place place) {
        return Optional.ofNullable(placeRepository.findPlaceByName(placeName))
                .map(p -> {
                    p.setPlaceName(place.getPlaceName());
                    p.setPlaceInfo(place.getPlaceInfo());
                    p.setOpeningHours(place.getOpeningHours());
                    p.setChargerType(place.getChargerType());
                    p.setCity(place.getCity());
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


    private Place placeNameToUpperCase(Place p) {
        p.setPlaceName(p.getPlaceName().toUpperCase());
        return p;
    }

    private Place updatePlaceResult(Place place) {
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

    public void getFile(String filename) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        CreatorXls<Place> placeFile = new CreatorXls<>(Place.class);
        placeFile.createFile(filename, getPlaces());
    }
}




