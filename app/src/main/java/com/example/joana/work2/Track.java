package com.example.joana.work2;

/**
 * Created by Joana on 2017/11/28.
 */

public class Track {
    private String trackId;
    private String trackName;

    public Track(){

    }

    public Track(String trackId, String trackName) {
        this.trackId = trackId;
        this.trackName = trackName;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }
}
