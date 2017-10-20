package com.degirogroup.assignment;

import java.util.ArrayList;
import java.util.List;

public class Schuur {
    private int name;
    private List<FlutePile> flutes;

    public Schuur(int name) {
        this.name = name;
        this.flutes = new ArrayList<>();
    }

    public void add(FlutePile pile) {
        flutes.add(pile);
    }

    public List<FlutePile> getFlutePiles() {
        return flutes;
    }

    public int getName() {
        return name;
    }
}
