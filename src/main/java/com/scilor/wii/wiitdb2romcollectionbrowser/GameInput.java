package com.scilor.wii.wiitdb2romcollectionbrowser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SciLor on 30.01.2017.
 */
public class GameInput {
    private byte players;
    private List<GameControl> controls;

    public GameInput() {
        controls = new ArrayList<GameControl>();
    }

    public byte getPlayers() {
        return players;
    }

    public void setPlayers(byte players) {
        this.players = players;
    }

    public List<GameControl> getControls() {
        return controls;
    }

    public void setControls(List<GameControl> controls) {
        this.controls = controls;
    }
}
