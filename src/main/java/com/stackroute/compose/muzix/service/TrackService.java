package com.stackroute.compose.muzix.service;

import com.stackroute.compose.muzix.domain.Track;
import com.stackroute.compose.muzix.exception.TrackAlreadyExistException;
import com.stackroute.compose.muzix.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistException;
    public List<Track> getAllTracks();
    public Track updateTrack(Track track) throws TrackNotFoundException;
    public Optional<Track> deleteTrack(int trackId) throws TrackNotFoundException;
    public Track trackByName(String trackName);
}
