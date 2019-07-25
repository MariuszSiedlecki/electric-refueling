package com.controllers;

import com.models.Place;
import com.services.PlaceServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    private PlaceServices placeServices;

    public PlaceController(PlaceServices placeServices) {
        this.placeServices = placeServices;
    }

    @GetMapping("/place")
    public ResponseEntity<Place> getPlaceByName(@RequestParam(value = "name") String placeName){
        return new  ResponseEntity<>(placeServices.getPlaceByName(placeName), HttpStatus.OK);

    }
}
