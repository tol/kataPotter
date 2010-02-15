(ns ro.tol.potter.ShoppingCart)

(def potter_price 8.0)

(defn getdiscount [x]
  ({1 1.0, 2 0.95, 3 0.90,4 0.80, 5 0.75} x)
 )

(defn calculatePriceForGroup [agroup]
   ;(println "calculated price for group " agroup " is " (* potter_price (count agroup) (getdiscount (count agroup))))
   (* potter_price (count agroup) (getdiscount (count agroup)))
 )

(defn calculateprice [books]
  ;(println " calculateprice for"  books)
 (reduce (fn [sum  group] (+ sum (calculatePriceForGroup  group)) )
           0.0
           books)
 )


(defn addItem[item aList] (conj aList item))

(defn removeItem[item aList] (disj aList item))
;(def minVal nil)
;(def foundGroup nil)
;(def oldGroup nil)
(defn getMinPrice [minVal price]
  (if ( nil? minVal )
        price
      ( if (<  price minVal)   price   minVal )
    )
 )

(defn getMinGroup [minVal price group newGroup]
  (if ( nil? minVal )
        newGroup 
       (if (<  price minVal)   newGroup   group )
    )
 )

(defn replaceGroupInList [l ng og]
   (let[
          nrDup (count (filter  #(= % og)  l))
          newL (cons    ng (remove #(= % og )l))]

          ( (fn [i b]
           (
             if (>= i nrDup)
                b
               (recur (+ i 1) (cons og b ))
               )
             ) 1  l)
      )
  )



(defn findGroupForBook [bookss bookk]

   ( (fn [ minVal foundGroup  book itBooks books ]

          (if (empty?  itBooks  )
             foundGroup 
            (   let [group (first itBooks)]

              (if ( not (contains?   group book))
                ;(recur   minVal foundGroup  book books )
              (
                let [
                newGroup (conj group book)
                newPrice (calculateprice (replaceGroupInList   books newGroup group))
                price (getMinPrice minVal newPrice)
                g ( getMinGroup minVal newPrice  foundGroup group)]
                ;(println "calculated price for " (cons    newGroup (rest books)) "is " newPrice)

                 (recur   price g book (rest itBooks) books)

                )

                (recur   minVal foundGroup  book (rest itBooks) books )
              )

            )


      )

     )   nil  (hash-set) bookk bookss bookss )  )




 (defn groupBook [bookss bookk]
   ;(println " bookk in groupBook 1 "   bookk bookss)
     (let[group (findGroupForBook bookss bookk)
          newGroup (conj group bookk)
          nrDup (count (filter  #(= % group)  bookss))
          newBooks (cons    (conj group bookk) (remove #(= % group )bookss))]
          ;(println " bookk in groupBook "    (cons    newGroup (remove #(= % group )bookss)))

          ( (fn [i b]
           (
             if (>= i nrDup)
                b
               (recur (+ i 1) (cons group b ))
               )
             ) 1  newBooks)
      )
   )



(defn groupBooks [bookks]
    (( fn [bookGroups books]
      (  if (empty?  books  )
              bookGroups
              (recur (groupBook bookGroups (first books) ) (rest books))

       ))
        [] bookks

      )

)


(defn price [books]
  (println "books grouped" (groupBooks books))
    (println "price for books grouped"     ( calculateprice (groupBooks books)))
    ( calculateprice (groupBooks books))


  ;(println " ( calculateprice (groupBooks books))"  ( calculateprice (groupBooks books)))

 )



