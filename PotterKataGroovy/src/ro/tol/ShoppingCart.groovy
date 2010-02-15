/**
 * Created by IntelliJ IDEA.
 * User: oana
 * Date: Sep 8, 2009
 * Time: 8:33:04 PM
 * To change this template use File | Settings | File Templates.
 */

//define discounts map
discounts=[1:1.0, 2:0.95, 3:0.90,4:0.80, 5:0.75]

//define potter price
 potter_price=8.0;

def calculatePriceForGroup(group)
{
     potter_price*group.size()*discounts[group.size()];
}

def calculatePrice(books)
{
  books.inject(0,{sum,item->calculatePriceForGroup(item)+sum})
}

def findGroupForBook(bookGroups,book)
{
  Set newGroup=null;
  min=null;
  bookGroups.each
  {
    if (!it.contains(book) )
      {
           Set tempNewGroup=it.clone();
           List newList=bookGroups.clone();
           newList.remove(it);
           newList.add(tempNewGroup);
           tempMin=calculatePrice(newList);
           if(min==null || tempMin<min)
           {
             newGroup=it;
             min=tempMin;
           }
      }

  }
  return newGroup;

}

def groupBooks(books)
{
  List bookGroups= new ArrayList();
  books.each
  {
    Set group= findGroupForBook(bookGroups,it);
    if (group==null){
      group=new HashSet()
       group.add(it)
    } else {

      bookGroups.remove(group);
      group.add(it);
    }
    bookGroups.add(group);

  }

  return bookGroups;

}


def price(books)
{
    calculatePrice (groupBooks(books))
}



print("price for group ${calculatePriceForGroup([1,2,3])}")

print("price for books ${calculatePrice([[1,2,3] as Set])}")

print("findGroupForBook ${findGroupForBook([[1,2,3] as Set],2)}")


print("price ${price([1,1,1,1,1,2,2,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5])}")

print("price ${price([1,1,2,2,3,3,4,5])}")