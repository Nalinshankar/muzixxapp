package com.stackroute.MuzixApplication.controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exception.TrackNotFindException;
import com.stackroute.MuzixApplication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class TrackController {
    TrackService trackService ;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping(value = "trackSave")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value = "getTrack")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(),HttpStatus.OK);
    }

    @PutMapping(value="getUpdate")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFindException {
        ResponseEntity responseEntity;
        try{
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("updated successfully",HttpStatus.OK);
        }catch (TrackNotFindException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "getDelete/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) throws TrackNotFindException{
        ResponseEntity<?>  responseEntity;
        try{
            trackService.removeTrack(trackId);
            responseEntity = new ResponseEntity<String>("successfully deleted",HttpStatus.OK);
        }catch(TrackNotFindException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
