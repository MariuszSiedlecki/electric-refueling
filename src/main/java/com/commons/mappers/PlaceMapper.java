package com.commons.mappers;


import com.models.Place;
import com.models.PlaceDto;
import com.models.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlaceMapper implements Mapper<Place, PlaceDto>{

    @Override
    public PlaceDto map(Place from) {
        List<String> tags = from.getTags()
                .stream()
                .map(TagsToStringsList.INSTANCE)
                .collect(Collectors.toList());
        return PlaceDto
                .builder()
                .placeName(from.getPlaceName())
                .address(from.getAddress())
                .chargerType(from.getChargerType())
                .openingHours(from.getOpeningHours())
                .placeInfo(from.getPlaceInfo())
                .image(from.getImage())
                .tag(tags)
                .build();
    }

    @Override
    public Place reverseMap(PlaceDto to) {
        return null;
    }

    private enum TagsToStringsList implements Function<Tag, String>{
        INSTANCE;

        @Override
        public String apply(Tag tag) {
            return tag.getTitle();
        }
    }
}
