package com.repositories;

import com.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

//    @Query(value = "select * from chargers where city = ?1",nativeQuery = true)
    @Query("select p from chargers p where p.placeName = ?1")
    Optional<Place> findPlaceByName(String placeName);

    @Query("select p from chargers p where " +
            "p.placeName like %?1%" +
            "or " +
            "p.placeInfo like %?1%"+
            "or " +
            "p.typeCharger like %?1%")
    List<Place> findPlacesByParam(String param);
}
