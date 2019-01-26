package com.stackroute.compose.muzix.service;

import com.stackroute.compose.muzix.domain.Track;
import com.stackroute.compose.muzix.exception.TrackAlreadyExistException;
import com.stackroute.compose.muzix.exception.TrackNotFoundException;
import com.stackroute.compose.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    TrackRepository trackRepository;
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException{
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistException("track already exist");
        }
        else {
            return trackRepository.save(track);
        }
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getTrackId())){
            return trackRepository.save(track);
        }
        else {
            throw  new TrackNotFoundException();
        }


    }

    @Override
    public Optional<Track> deleteTrack(int trackId) throws TrackNotFoundException {
        if(trackRepository.existsById(trackId)){
            Optional<Track> deletedTrack = trackRepository.findById(trackId);
            trackRepository.deleteById(trackId);
             return deletedTrack;
        }
        else {
            throw new TrackNotFoundException();
        }
    }

    @Override
    public Track trackByName(String trackName) {
        return trackRepository.findBytrackName(trackName);

    }


}
