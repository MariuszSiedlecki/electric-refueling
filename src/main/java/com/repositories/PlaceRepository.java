package com.repositories;

import com.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("select p from Place p where p.city = ?1")
    Place findPlaceByName(String city);

    @Query("select p from Place p where " +
            "p.placeName like %?1% " +
            "or " +
            "p.placeInfo like %?1% " +
            "or " +
            "p.chargerType like %?1%")
    List<Place> findPlacesByParam(String param);



    @Transactional
    @Modifying
    @Query("delete from Place p where p.placeName = ?1")
    int deletePlaceByName(String placeName);
}
