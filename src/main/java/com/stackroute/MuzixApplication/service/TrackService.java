package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exception.TrackNotFindException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTrack();
    public boolean updateTrack(Track track) throws TrackNotFindException;
    public boolean removeTrack(int trackId)throws TrackNotFindException;
}
