(ns ro.tol.potter.test.ShoppingCartTest)
(use 'clojure.test)
(use 'ro.tol.potter.ShoppingCart)

; Tests can be written in separate functions.
(deftest getdiscounttest
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
  (is (= 1.0 (getdiscount 1)) "get discounts test")
  (is (= 0.75 (getdiscount 5)) "get discounts test")
   )

(deftest calculatepriceforgrouptest
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
 ; (is (= 21.6 (calculatePriceForGroup (hash-set 1 2 3))) "calculate price for group")

   )


(deftest calculatepricetest
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
  ;(is (= 58.4 (calculateprice (list (hash-set 1 2 ) (hash-set 1 2 3) (hash-set 1 2 3)))) "calculate price ")
  ;(is (= 51.2 (calculateprice (list #{1 2 3 5} #{1 2 3 4}) )) "calculate price ")

   )

(deftest groupBookstest
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
  ;(is (= (list (set [1])) (groupBook #{} 1 )) "group one book ")
  ;(is (= (list (set [1 2])) (groupBook (list (set [1])) 2 )) "group one book ")
  ;(is (= (list (set [ 2]) (set [1 2]) ) (groupBook (list (set [1 2])) 2 )) "group three book ")
  ;(is (= (list  (set [2 3 4 ]) (set [1 2])  ) (groupBook (list (set [1 2]) (set [3 4])) 2 )) "group three book ")
  ;(is (= (6 (factorial3 3)) "fact"))
   )


(deftest pricetest
  ; The "is" macro takes a predicate, arguments to it,
  ; and an optional message.
  (is (= (list (set [1])) (groupBook #{} 1 )) "group one book ")
   (is (= (* 8.0 2.0 0.95) (price  [1 2] )) "price two book ")
  (is (= (+ (* 8.0 4.0 0.80) (* 8.0 4.0 0.80)) (price  [1 1 2 2 3 3 4 5] )) "price multiple books 1 ")
   (is (= (+ (* 3 8.0 5.0 0.75) (* 2 8.0 4.0 0.80)) (price  [1 1 1 1 1 2 2 2 2 2 3 3 3 3 4 4 4 4 4 5 5 5 5] )) "price multiple books 2 ")
 ; (is (= (list (set [ 2]) (set [1 2]) ) (groupBook (list (set [1 2])) 2 )) "group three book ")
  ;(is (= (list  (set [2 3 4 ]) (set [1 2])  ) (groupBook (list (set [1 2]) (set [3 4])) 2 )) "group three book ")
  ;(is (= (6 (factorial3 3)) "fact"))
   )

;
;   def testMultipleElementList2() {
;   def p=ShoopingCart.price(List(0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4))
;   Console.print("calculated"+p+" expected "+(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8)))
;   assert(p == 3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8))
;}


;(deftest reverse-test
 ; (is (= [3 2 1] (reverse [1 2 3]))))

; Tests can verify that a specific exception is thrown.
;(deftest division-test
 ; (is (thrown? ArithmeticException (/ 3.0 0))))

; The with-test macro can be used to add tests
; to the functions they test as metadata.
;(with-test
;  (defn my-add [n1 n2] (+ n1 n2))
;  (is (= 4 (my-add 2 2)))
 ; (is (= 2 (my-add 2 0)) "adding zero doesn't change value"))

; The "are" macro takes a predicate template and
; multiple sets of arguments to it, but no message.
; Each set of arguments are substituted one at a time
; into the predicate template and evaluated.
;(deftest multiplication
;  (are [n1 n2 result]
;    (= (* n1 n2) result) ; a template
;    1 1 1,
;    1 2 2,
;    2 3 6))

; Run all the tests in the current namespace.
; This includes tests that were added as function metadata with with-test.
; Other namespaces can be specified as quoted arguments.
(run-tests)

