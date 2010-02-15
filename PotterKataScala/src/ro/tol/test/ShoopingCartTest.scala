package ro.tol.test


import org.scalatest.junit.JUnit3Suite
import org.scalatest.prop.Checkers
import ro.tol.ShoopingCart

/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Aug 10, 2009
 * Time: 11:26:41 PM
 * To change this template use File | Settings | File Templates.
 */

class ShoopingCartTest extends JUnit3Suite {

  def testOneElementList() {
    def p=ShoopingCart.price(List(0));
    assert(p == 8.0)
 }


  def testTwoElementList() {
    def p=ShoopingCart.price(List(0,1))
    Console.print("calculated"+p+" expected "+8.0*2*0.95)
    assert(p == 8.0*2*0.95)
 }

  def testMultipleElementList1() {
    def p=ShoopingCart.price(List(0,0,1,1,2,2,3,4))
    Console.print("calculated"+p+" expected "+(8.0*4*0.80+8.0*4*0.80))
    assert(p == 8.0*4*0.80+8.0*4*0.80)
 }

    def testMultipleElementList2() {
    def p=ShoopingCart.price(List(0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4))
    Console.print("calculated"+p+" expected "+(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)))
    assert(p == 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8))
 }


}
