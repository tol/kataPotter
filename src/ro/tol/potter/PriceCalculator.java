package ro.tol.potter;

import java.util.*;

public class PriceCalculator {

    private final ShoopingCart shoopingCart;

    private static Map<Integer, Double> discounts = new HashMap<Integer, Double>();
    private static final double POTTER_PRICE = 8.0;

    static{
        discounts.put(1, 1.0);
        discounts.put(2, 0.95);
        discounts.put(3, 0.90);
        discounts.put(4, 0.80);
        discounts.put(5, 0.75);
     }

    public PriceCalculator(ShoopingCart shoopingCart) {
        this.shoopingCart = shoopingCart;
    }

    private void putBookInGroupEntry(List<Set<Book>> bookGroups, Book book) {
        Map<Integer, Book> result;
        boolean found = false;
        Double min = null;
        Set<Book> foundEntry = null;
        for (Set<Book> entry : bookGroups) {
            if (!entry.contains(book)) {

                found = true;
                Double intermediateMin = calculatePriceForNewBookINBookSet(bookGroups,entry, book);
                if (min == null || min > intermediateMin) {
                    min = intermediateMin;
                    foundEntry = entry;
                }

            }
        }
        if (!found) {
            Set<Book> newEntry = new HashSet<Book>();
            newEntry.add(book);
            bookGroups.add(newEntry);
            System.out.println("Add new entry for book "+book);
        } else {
            foundEntry.add(book);
            System.out.println("put book "+book+" in entry"+ foundEntry);
        }
    }

    private Double calculatePriceForNewBookINBookSet(List<Set<Book>> bookGroups,Set<Book> bookSet, Book book) {
        Set<Book> newBookSet = new HashSet<Book>();
        newBookSet.addAll(bookSet);
        newBookSet.add(book);
        Double   totalPrice=0.0;
        for (Set<Book> bookGroup : bookGroups) {
            if(!bookGroup.equals(bookSet))
                totalPrice += calculatePriceForBookSet(bookSet);
            else
                totalPrice += calculatePriceForBookSet(newBookSet);
        }
        return totalPrice;
    }

    private Double calculatePriceForBookSet(Set<Book> bookSet) {

        Double result;
        result = bookSet.size() * POTTER_PRICE * discounts.get(bookSet.size());
        return result;
    }

    public Double price() {
        Double totalPrice = 0.0;
        List<Set<Book>> bookGrooping = new ArrayList<Set<Book>>();
        for (Book book : shoopingCart.getBooks()) {
            putBookInGroupEntry(bookGrooping, book);
        }
        for (Set<Book> bookSet : bookGrooping) {
            totalPrice += calculatePriceForBookSet(bookSet);
        }
        return totalPrice;
    }
}