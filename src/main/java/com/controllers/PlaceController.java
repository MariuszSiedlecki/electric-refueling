package com.controllers;

import com.models.Place;
import com.services.PlaceServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlaceController {
    private PlaceServices placeServices;

    public PlaceController(PlaceServices placeServices) {
        this.placeServices = placeServices;
    }

    @GetMapping({"/", "/api", "/api/v1"})
    public String message() {
        return "empty";
    }

    @GetMapping("/api/v1/place")
    public ResponseEntity<Place> getPlaceByName(@RequestParam(value = "name") String placeName) {
        Place result = placeServices.getPlaceByName(placeName);
        if (result != null) {
            return new ResponseEntity<>(placeServices.getPlaceByName(placeName), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/v1/place/optional")
    public ResponseEntity<Optional<Place>> getPlaceByNameOptional(@RequestParam(value = "name") String placeName) {
        return new ResponseEntity<>(placeServices.getOptionalPlaceByName(placeName), HttpStatus.OK);
    }

    @GetMapping("/api/v1/places")
    public List<Place> getPlace(@RequestParam(value = "param", required = false) String param) {
        if (StringUtils.isEmpty(param)) {
            return placeServices.getPlaces();
        } else {
            return placeServices.getPlaces(param);
        }
    }

    @PostMapping("/api/v1/place")
    public ResponseEntity<Place> addPlace(@RequestBody Place place) {
        return ResponseEntity
                .ok()
                .header("example_header", "example_header_1")
                .body(placeServices.savePlace(place));
    }

    @PutMapping("/api/v1/place")
    public ResponseEntity<Place> updatePlace(@RequestParam(value = "name") String placeName, @RequestBody Place place) {
        Place result = placeServices.updatePlace(placeName, place);
        if (result != null) {
            return ResponseEntity
                    .ok()
                    .header("example_header", "example_header_1")
                    .body(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/api/v1/place")
    public ResponseEntity<?>deletePlaceByName(@RequestParam(value = "name") String placeName){
        if(placeServices.deletePlaceByName(placeName)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}