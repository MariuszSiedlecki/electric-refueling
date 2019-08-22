package com.controllers;

import com.commons.Naming;
import com.commons.extras.CreatorXls;
import com.commons.extras.DirectoryCreator;
import com.models.Place;
import com.models.PlaceDto;
import com.services.PlaceService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PlaceController {


    private PlaceService placeService;

    public PlaceController(PlaceService placeServices) {
        this.placeService = placeServices;
        DirectoryCreator.createDirectory();
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

    @GetMapping(value = "/api/v1/places/file")
    public void getPlacesInFile(@RequestParam String filename) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        placeService.getFile(filename);
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
    @GetMapping("/api/v1/places/download/file/xls/{filename}")
    public ResponseEntity<Resource> downloadXls(@PathVariable String filename) throws IOException {
        Resource resource = new UrlResource(Paths.get(Naming.LOCAL_PATH + filename).toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/excel"))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFile().getName() +"\"")
                .contentLength(resource.getFile().length())
                .body(resource);
    }
}