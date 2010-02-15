package ro.tol


import java.util.ArrayList

/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Aug 10, 2009
 * Time: 11:31:27 PM
 * To change this template use File | Settings | File Templates.
 */

object ShoopingCart {
   val discounts=Map(1-> 1.0,2-> 0.95,3-> 0.90,4-> 0.80,5-> 0.75)
   val POTTER_PRICE=8.0;

  def calculatePriceForGroup(bookSet:Set[Int]):Double=
  {
        return  POTTER_PRICE*bookSet.size*discounts(bookSet.size);
  }

  def calculatePriceForBooks(bookGroups:List[Set[Int]]):Double=
  {  def x=0.0;
     return bookGroups.foldLeft(0.0){(sum,a)=>(sum+calculatePriceForGroup(a))};

   }

  def evaluateMove(bookGroups:List[Set[Int]],set:Set[Int], b: Int):Double={
       var total=0.0

    bookGroups.foldLeft(0.0){(sum,a)=>(if (a!=set) return sum+calculatePriceForGroup(a)
                                       else {
                                            var tempSet : Set[Int]=Set();
                                            set.foreach(x=> tempSet+=x)
                                            tempSet+=b;
                                        return sum+calculatePriceForGroup(tempSet)})};
       
      return total;
  }

  def groupBooks(l:List[Int]):List[Set[Int]]=
   {
        var bookGroups:List[Set[Int]]=List();

        l.foreach(x=> {
                         var min:Double=0.0;
                         var found=false;
                         var ming:Set[Int]=Set();
                         bookGroups.foreach(g=> { if (!g.contains(x)) {  val sum= evaluateMove(bookGroups,g,x);

                                                                         if(!found || sum<min) {min=sum;ming=g }
                                                                         found=true;
                                                                       }
                                                 }
                                            )
                                  if (!found) {
                                    var newG:Set[Int]=Set();
                                    newG+= x;
                                    bookGroups+=newG
                                    //Console.print("added new group"+newG)
                                  }  else {
                                   //  Console.print("ming="+ming)
                                    //bookGroups.remove(x1=>{ Console.print("x1="+x1);return x1==ming});
                                    var tempBookGroups:List[Set[Int]]=List()
                                    bookGroups.foreach(x1=>  if (x1==ming ){ming+=x; tempBookGroups+=ming} else {tempBookGroups+=x1})

                                    bookGroups=tempBookGroups
                                    //Console.print("add to  group"+ming)
                                  }
                      }

          )
           Console.print("groups("+bookGroups+")")
        return  bookGroups;
   }


   def price(l:List[Int]):Double ={

        return calculatePriceForBooks(groupBooks(l));
  }

}