package com.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceDto {

    private String city;
    private String placeName;
    private String address;
    private String openingHours;
    private String placeInfo;
    private String chargerType;
    private String image;
    private List<String>tags= new ArrayList<>();
}
