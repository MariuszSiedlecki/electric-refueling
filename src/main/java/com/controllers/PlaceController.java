package com.controllers;

import com.models.Place;
import com.models.PlaceDto;
import com.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeServices) {
        this.placeService = placeServices;
    }

    @GetMapping("/api/v1/place")
    public ResponseEntity<Place> getPlaceByName(@RequestParam(value = "name") String placeName) {
        Place result = placeService.getPlaceByName(placeName);
        if (result != null) {
            return new ResponseEntity<>(placeService.getPlaceByName(placeName), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/api/v1/places",produces = "application/json")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @GetMapping(value = "/api/v1/places/dto", produces = "application/json")
    public List<PlaceDto> getPlacesDto() {
        return placeService.getPlacesDto();
    }

    @GetMapping(value = "/api/v1/places/dto/xml",produces = "application/xml")
    public List<PlaceDto> getPlacesDtoXml() {
        return placeService.getPlacesDto();
    }

    @PostMapping(value = "/api/v1/place", produces = "application/json")
    public ResponseEntity<Place> addPlace(@RequestBody Place place) {
        return ResponseEntity
                .ok()
                .header("example_header", "example_header_1")
                .body(placeService.savePlace(place));
    }

    @PutMapping(value = "/api/v1/place", produces = "application/json")
    public ResponseEntity<Place> updatePlace(@RequestParam(value = "name") String placeName, @RequestBody Place place) {
        Place result = placeService.updatePlace(placeName, place);
        if (result != null) {
            return ResponseEntity
                    .ok()
                    .header("example_header", "example_header_1")
                    .body(result);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/v1/place", produces = "application/json")
    public ResponseEntity<?>deletePlaceByName(@RequestParam(value = "name") String placeName){
        if(placeService.deletePlaceByName(placeName)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}