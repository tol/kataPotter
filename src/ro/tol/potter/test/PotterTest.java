package ro.tol.potter.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import ro.tol.potter.ShoopingCart;
import ro.tol.potter.Book;

/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Aug 9, 2009
 * Time: 8:09:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PotterTest {
   private  ShoopingCart shoopingCart;

    @Before
    public void prepareShoppingCart()
    {
        shoopingCart=new ShoopingCart();

    }

    @Test
    public void testSingleBookShoppingCart()
    {
           shoopingCart.add(new Book(1)) ;
           assertEquals("price",shoopingCart.price(),new Double(8.0));
    }

    @Test
    public void testTwoBooksBookShoppingCart()
    {
           shoopingCart.add(new Book(1)).add(new Book(2)) ;
           assertEquals("price",new Double(15.2),shoopingCart.price());
    }

        @Test
    public void testMultipleBooksBookShoppingCart()
    {
            shoopingCart.add(new Book(1))
                        .add(new Book(1))
                        .add(new Book(2))
                        .add(new Book(2))
                        .add(new Book(3))
                        .add(new Book(3))
                        .add(new Book(4))
                        .add(new Book(5)) ;
           assertEquals("testMultipleBooksBookShoppingCart price",new Double(51.20),shoopingCart.price());
    }

    @Test
    public void testMultipleBooksBookShoppingCart2()
    {
            shoopingCart.add(new Book(1))
                        .add(new Book(1))
                        .add(new Book(2))
                        .add(new Book(3))
                        .add(new Book(4))
                        .add(new Book(4))
                        .add(new Book(5))
                        .add(new Book(5));
           assertEquals("testMultipleBooksBookShoppingCart2 price",new Double(51.20),shoopingCart.price());
    }



        @Test
    public void testMultipleBooksBookShoppingCart3()
    {
            shoopingCart.add(new Book(1))
                        .add(new Book(1))
                        .add(new Book(1))
                        .add(new Book(1))
                     .add(new Book(1))
                        .add(new Book(2))
                    .add(new Book(2))
                    .add(new Book(2))
                    .add(new Book(2))
                    .add(new Book(2))
                        .add(new Book(3))
                    .add(new Book(3))
                    .add(new Book(3))
                    .add(new Book(3))
                        .add(new Book(4))
                        .add(new Book(4))
                    .add(new Book(4))
                    .add(new Book(4))
                     .add(new Book(4))
                        .add(new Book(5))
                    .add(new Book(5))
                    .add(new Book(5))
                        .add(new Book(5));
           assertEquals("testMultipleBooksBookShoppingCart3 price",new Double(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)),shoopingCart.price());
    }

   

}
