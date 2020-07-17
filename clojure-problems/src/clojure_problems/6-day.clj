(ns clojure-problems.core)

;;6일차

;;Fibonacci Sequence
(= (#(take % (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))) 3) '(1 1 2))
(= (#(take % ((fn fib [x y] (lazy-seq (cons x (fib y (+ x y))))) 1 1)) 6) '(1 1 2 3 5 8))
(= ( 8) '(1 1 2 3 5 8 13 21))

(take 10 (iterate (fn [[a b]] [b (+ a b)]) [1 1]))
(take 10 ((fn fib [x y] (lazy-seq (cons x (fib y (+ x y))))) 1 1))

;;Get the Caps
(= (#(reduce str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!") "HLOWRD")
(empty? (#(apply str (re-seq #"[A-Z]" %)) "nothing"))
(= (#(reduce str (re-seq #"[A-Z]" %)) "$#A(*&987Zf") "AZ")

(= ( "HeLlO, WoRlD!") "HLOWRD")

(re-seq #"[A-Z]" "HeLlO, WoRlD!")
(reduce str (re-seq #"[A-Z]" "HeLlO, WoRlD!"))


;;Intro to some
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))


;;Factorial Fun
(= (#(apply * (range 1 (inc %))) 1) 1)
(= (#(apply * (range 1 (+ % 1))) 3) 6)
(= (#(apply * (range 2 (inc %))) 5) 120)
(= (#(apply * % (range 2 %)) 8) 40320)

(range 1 (+ 3 1))
(apply * (range 1 (+ 3 1)))


;;Intro to Destructuring
(= [2 4] (let [[a b c d e] [0 1 2 3 4] ]))

(= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e]))







