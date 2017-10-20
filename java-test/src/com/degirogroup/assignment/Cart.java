package com.degirogroup.assignment;

public class Cart {
    private final int flutes;
    private final int profit;

    public Cart(int flutes, int profit) {
        this.flutes = flutes;
        this.profit = profit;
    }

    public int getFlutes() {
        return flutes;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "flutes=" + flutes +
                ", profit=" + profit +
                '}';
    }
}
