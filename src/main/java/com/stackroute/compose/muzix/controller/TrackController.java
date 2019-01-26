package com.stackroute.compose.muzix.controller;

import com.stackroute.compose.muzix.domain.Track;
import com.stackroute.compose.muzix.exception.TrackAlreadyExistException;
import com.stackroute.compose.muzix.exception.TrackNotFoundException;
import com.stackroute.compose.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TrackController {

    @Autowired
    TrackService trackService;

    @PostMapping("/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException{
        return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.OK);
    }


    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @PutMapping("/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        return new ResponseEntity<>(trackService.updateTrack(track), HttpStatus.CREATED);
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable("trackId") int trackId) throws TrackNotFoundException{
        return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
    }

    @GetMapping("/track/{trackName}")
    public ResponseEntity<?> trackByName(@PathVariable("trackName") String trackName){
        return new ResponseEntity<>(trackService.trackByName(trackName),HttpStatus.OK);
    }
}
