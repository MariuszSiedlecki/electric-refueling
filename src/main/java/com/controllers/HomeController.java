package com.controllers;

import com.services.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private PlaceService placeService;
    private PlaceMapper placeMapper;

    public HomeController(PlaceService placeService, PlaceMapper placeMapper) {
        this.placeService = placeService;
        this.placeMapper = placeMapper;
    }

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
}
