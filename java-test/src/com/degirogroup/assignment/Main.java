package com.degirogroup.assignment;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TestCase t = new TestCase();

        List<FlutePile> flutePileList = new ArrayList<>();
        FlutePile flutePile = new FlutePile();
        flutePile.add(12);
        flutePile.add(3);
        flutePile.add(10);
        flutePile.add(7);
        flutePile.add(16);
        flutePile.add(5);

        Schuur schuur =  new Schuur(1);
        schuur.add(flutePile);
        t.addSchuur(schuur);

        ProfitCalculator calculator = new ProfitCalculator(10);
        calculator.calculateMaxProfit(t);

    }
}
