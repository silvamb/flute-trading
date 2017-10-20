package com.degirogroup.assignment;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    private List<Schuur> schuurList;

    public TestCase() {
        schuurList = new ArrayList<>();
    }

    public void addSchuur(Schuur schuur) {
        schuurList.add(schuur);
    }

    public List<Schuur> getSchuurList() {
        return schuurList;
    }
}
