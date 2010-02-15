package ro.tol.potter;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Aug 9, 2009
 * Time: 8:35:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoopingCart {

    private List<Book>  books;
    private final PriceCalculator priceCalculator = new PriceCalculator(this);

    public ShoopingCart()
    {
        books= new ArrayList<Book>();
    }

    public ShoopingCart add(Book book) {

            books.add(book);
            return this;
     }

    public Double price() {
        return priceCalculator.price();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
