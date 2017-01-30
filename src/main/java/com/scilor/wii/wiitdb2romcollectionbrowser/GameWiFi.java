package com.scilor.wii.wiitdb2romcollectionbrowser;

import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class GameWiFi {
    private byte players;
    private List<String> features; //online

    public byte getPlayers() {
        return players;
    }

    public void setPlayers(byte players) {
        this.players = players;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
