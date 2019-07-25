package com.controllers;

import com.models.Place;
import com.services.PlaceServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlaceController {
    private PlaceServices placeServices;

    public PlaceController(PlaceServices placeServices) {
        this.placeServices = placeServices;
    }
    @GetMapping({"/","/api","/api/v1"})
    public String message(){
        return "empty";
    }

    @GetMapping("/api/v1/place")
    public ResponseEntity<Place> getPlaceByName(@RequestParam(value = "name") String placeName){
        return new  ResponseEntity<>(placeServices.getPlaceByName(placeName), HttpStatus.OK);
    }

    @GetMapping("/api/v1/place/optional")
    public ResponseEntity<Optional<Place>> getPlaceByNameOptional(@RequestParam(value = "name") String placeName){
        return new  ResponseEntity<>(placeServices.getOptionalPlaceByName(placeName), HttpStatus.OK);
    }
    @GetMapping("/api/v1/places")
    public List<Place>getPlace(@RequestParam(value = "param",required = false)String param){
        if(StringUtils.isEmpty(param)){
            return placeServices.getPlaces();
        }else {
            return placeServices.getPlaces(param);
        }
    }
}
