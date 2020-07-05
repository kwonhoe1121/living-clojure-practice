(ns clojure-problems.core)

;;4일차

;;Penultimate Element
(= (#(first (rest (reverse %))) (list 1 2 3 4 5)) 4)
(= (#(second (reverse %)) (list 1 2 3 4 5)) 4)
(= (#(last (butlast %)) (list 1 2 3 4 5)) 4)
(= ((comp second reverse) (list 1 2 3 4 5)) 4)

(first (rest (#(reverse %) (list 1 2 3 4 5))))
(first (rest (#(reverse %) ["a" "b" "c"])))
(first (rest (#(reverse %) [[1 2] [3 4]])))

;;Sum It All Up
(= (#(reduce + %) [1 2 3]) 6)
(= (apply + [1 2 3]) 6)
(= (reduce + [1 2 3]) 6)

(= (apply + (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)


;;Find the odd numbers
;Example of 'for' usage. for []
(= (#(for [x %
       :when (= 1 (rem x 2))]
       x) #{1 2 3 4 5}) '(1 3 5))

(= (filter odd? [4 2 1 6]) '(1))
(= (filter odd? [2 2 4 6]) '())
(= (filter odd? [1 1 1 3]) '(1 1 1 3))

;;Palindrome Detector 
;compare between sequentials
(true? (#(= (seq %) (reverse %)) '(1 2 3 4 5)))
(false? (#(= % (reverse %)) '(1 2 3 4 5)))
(true? (#(= (seq %) (reverse %)) "racecar"))
(true? (#(if (string? %) (= (char-name-string %) (char-name-string (reverse %))) (= % (reverse %))) "racecar"))
(true? (#(= (seq %) (reverse %)) [:foo :bar :foo]))

(#(for [x % y (reverse %)]
    (if (string? x) (= (char-name-string x) (char-name-string y)) (= x y))) '(1 2 3 4 5))

;이하 삽질 한 코드
(#(if (string? %) (= (char-name-string %) (char-name-string (reverse %))) (= % (reverse %))) '(1 2 3 4 5))
(#(if (string? %) (= (char-name-string %) (char-name-string (reverse %))) (= % (reverse %))) "racecar")

(true? (= (#(str (reverse %) "") "racecar")))
(true? (= #(reverse %) "racecar"))

(true? (= #(for [x % y (reverse %)]
             (== x y)) "racecar"))

(true? (= #(for [x % y (reverse %)]
             (== x y)) '(1 2 3 2 1)))

(= "racecar" "racecar")

(defn foo [x y]
  (if (string? x) (= (char-name-string x) (char-name-string y)) (= x y)))

(string? "racecar")
(foo "SOS" (reverse "SOS"))
(foo "racecar" (reverse "racecar"))
(foo '(1 2 3 2 1) (reverse '(1 2 3 2 1)))
(foo '(\r \r) (reverse '(\r \r)))

(#(class (reverse %))  "racecar")
(#(class (str (reverse %) ""))  "racecar")

(#(println (reverse %)) "racecar")

;;Duplicate a Sequence
(= ( [1 2 3])  '(1 1 2 2 3 3))
(= ( [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))



(defn foo2 [in out]
  (when (empty? in) out)
  (conj out (first in) (first in))
  (recur (rest in) out))

(defn foo3 [in out]
  (if (empty? in)
    out
    (foo3
      (rest in)
      (conj out (first in) (first in)))))

(foo3 [1 2 3] [])
(foo3 [:a :a :b :b] [])
(foo3 [[1 2] [3 4]] [])

(defn advn_foo3 [input]
  (loop [in input
         out []]
    (if (empty? in)
      out
      (recur (rest in)
             (conj out (first in) (first in))))))

(advn_foo3 [1 2 3] )
(advn_foo3 [:a :a :b :b] )
(advn_foo3 [[1 2] [3 4]] )

(#(loop [in %
          out []]
     (if (empty? in)
       out
       (recur (rest in)
              (conj out (first in) (first in))))) [1 2 3])


(= (mapcat #(list % %) [1 2 3])  '(1 1 2 2 3 3))
(= (#(interleave % %) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))


(mapcat (list [1 2 3] [1 2 3])) 

(#(interleave % %) [1 3 5])







