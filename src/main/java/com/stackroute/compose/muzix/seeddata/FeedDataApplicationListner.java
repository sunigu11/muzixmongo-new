package com.stackroute.compose.muzix.seeddata;

import com.stackroute.compose.muzix.domain.Track;
import com.stackroute.compose.muzix.exception.TrackAlreadyExistException;
import com.stackroute.compose.muzix.service.TrackService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class FeedDataApplicationListner implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Environment environment;

    @Autowired
    TrackService trackService;

    Track feedData = new Track();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        feedData.setTrackId(Integer.parseInt(environment.getProperty("song.1.trackId")));
        feedData.setTrackName(environment.getProperty("song.1.trackName"));
        feedData.setTrackComment(environment.getProperty("song.1.trackComment"));
        try {
            trackService.saveTrack(feedData);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
        feedData.setTrackId(Integer.parseInt(environment.getProperty("song.2.trackId")));
        feedData.setTrackName(environment.getProperty("song.2.trackName"));
        feedData.setTrackComment(environment.getProperty("song.2.trackComment"));
        try {
            trackService.saveTrack(feedData);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
        feedData.setTrackId(Integer.parseInt(environment.getProperty("song.3.trackId")));
        feedData.setTrackName(environment.getProperty("song.3.trackName"));
        feedData.setTrackComment(environment.getProperty("song.3.trackComment"));
        try {
            trackService.saveTrack(feedData);
        } catch (TrackAlreadyExistException e) {
            e.printStackTrace();
        }
    }
}
