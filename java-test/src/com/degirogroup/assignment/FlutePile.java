package com.degirogroup.assignment;

import java.util.ArrayList;
import java.util.List;

public class FlutePile {

    private List<Integer> flutePrices;

    public FlutePile() {
        this.flutePrices = new ArrayList<>();
    }

    public void add(int flutePrice) {
        flutePrices.add(flutePrice);
    }

    public List<Integer> getFlutePrices() {
        return flutePrices;
    }

}
