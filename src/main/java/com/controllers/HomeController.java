package com.controllers;

import com.commons.mappers.PlaceMapper;
import com.models.PlaceDto;
import com.services.PlaceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private PlaceService placeService;
    private PlaceMapper placeMapper;

    public HomeController(PlaceService placeService, PlaceMapper placeMapper) {
        this.placeService = placeService;
        this.placeMapper = placeMapper;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER','GUEST')")
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("places", placeService.getPlacesDto());
        return "index";
    }
    @GetMapping("/add-place")
    public String addPage(){
        return "add-place";
    }
    @GetMapping("/delete")
    public String deletePlace(@RequestParam(value = "place") String placeName){
        placeService.deletePlaceByName(placeName);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String updatePlace(@RequestBody()PlaceDto place){

        return "redirect:/";
    }
    @PostMapping("/add")
    public String addPlace(@ModelAttribute() PlaceDto placeDto){
        System.out.println(placeDto);
        placeService.savePlace(placeMapper.reverseMap(placeDto));

        return "redirect:/";
    }
}
