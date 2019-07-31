package com.controllers;

import com.services.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private PlaceService placeService;

    public HomeController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("places", placeService.getPlacesDto());
        return "index";
    }
}
