package com.degirogroup.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProfitCalculator {

    private final int flutePrice;

    public ProfitCalculator(int flutePrice) {
        this.flutePrice = flutePrice;
    }

    public void calculateMaxProfit(TestCase t) {
        t.getSchuurList().forEach(this::printReport);
    }


    private void printReport(Schuur schuur) {
        List<Cart> profits = calculateMaxProfit(schuur);
        profits.sort(Comparator.comparingInt(Cart::getProfit));

        System.out.println("Schuurs " + schuur.getName());
        System.out.println("Maximum profit is " + profits.get(0).getProfit());
        System.out.print("Number of fluts to buy: ");
        profits.forEach(c -> System.out.print(c.getFlutes() + " "));
        System.out.println();
    }


    private List<Cart> calculateMaxProfit(Schuur schuur) {
        List<Cart> carts = new ArrayList<>();

        for(FlutePile pile : schuur.getFlutePiles()) {
            List<Cart> pileMaxProfits = calculateMaxProfit(pile);
            carts = merge(carts, pileMaxProfits);
        }

        return carts;
    }

    private List<Cart> calculateMaxProfit(FlutePile pile) {
        List<Integer> flutePrices = pile.getFlutePrices();

        List<Cart> profitList = new ArrayList<>();

        int profit = 0;
        for(int i = 0; i < flutePrices.size(); i++) {
            profit += (flutePrice - flutePrices.get(i));
            profitList.add(new Cart(i+1, profit));
        }

        return profitList.stream()
                .collect(Collectors.groupingBy(
                        Cart::getProfit,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toList()))
                .firstEntry()
                .getValue();
    }

    private List<Cart> merge(List<Cart> currentList, List<Cart> accumulator) {
        final List<Cart> profitList = new ArrayList<>();

        if(currentList.isEmpty()) {
            return accumulator;
        }

        currentList.stream().forEach(c -> {
            accumulator.stream()
                    .forEach(s -> profitList.add(merge(c,s)));
        });

        return profitList;
    }

    private Cart merge(Cart aCart, Cart anotherCart) {
        int newFlutes = aCart.getFlutes() + anotherCart.getFlutes();
        int newProfit = aCart.getProfit() + anotherCart.getProfit();

        return new Cart(newFlutes, newProfit);
    }


}
