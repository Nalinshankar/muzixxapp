package com.stackroute.MuzixApplication.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Track {
    @Id
    private int trackId;
    @Column
    private String trackName;
    @Column
    private String comment;
}
