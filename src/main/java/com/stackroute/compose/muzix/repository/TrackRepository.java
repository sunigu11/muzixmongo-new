package com.stackroute.compose.muzix.repository;

import com.stackroute.compose.muzix.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

    //@Query("SELECT t FROM track t WHERE t.trackName-=?1")
    public Track findBytrackName(String trackName);
}
