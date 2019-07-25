package com.models;

import lombok.*;

import javax.persistence.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
@Builder
@Entity
@Table(name="chargers")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "address")
    private String address;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name ="place_info")
    private String placeInfo;

    @Column(name = "charger_type")
    private String chargerType;

    @Column(name = "image")
    private String image;

}
