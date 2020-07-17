(ns clojure-problems.core)

;;8일차

;;Simple closures - f (g(x))
(= 256 (((fn [n] (fn [b] (int (Math/pow b n)))) 2) 16) (((fn [n] (fn [b] (int (Math/pow b n)))) 8) 2))
(= [1 8 27 64] (map ((fn [n] #(apply * (repeat n %)))3) [1 2 3 4]))
(= [1 2 4 8 16] (map #(( %) 2 [0 1 2 3 4])))

#(fn [x] (Math/pow x %))
(fn [n] #(apply * (repeat n %)))3
(fn [n] (fn [b] (int (Math/pow b n)))) 3


(= [1 8 27 64] (map ((fn [n] (fn [b] (int (Math/pow b n)))) 3) [1 2 3 4]))

(defn make-n-factorial [n]
  )


(repeat 3 1)
(repeat 3 2)
(repeat 3 3)
(repeat 3 4)
(apply * (repeat 3 2))


;;Cartesian Product
;;(= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
;;   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
;;     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
;;     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

(= ((fn [a b] (into #{} (for [x a y b] [x y]))) #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
(= (#(set (for [x %1 y %2] [x y])) #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

(= 300 (count (#(set (for [x %1 y %2] [x y])) (into #{} (range 10))
               (into #{} (range 30)))))

(= ( #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

((fn [a] (fn [b] [a b])) #{1 2 3} #{4 5})

((fn [a b] (for [x (vec a) y (vec b)] [x y])) #{1 2 3} #{4 5})

((fn [a b] (for [x a y b] [x y])) #{1 2 3} #{4 5}) 
((fn [a b] (into #{} (for [x a y b] [x y]))) #{1 2 3} #{4 5}) 

(take 100 (for [x (range 100000000) y (range 1000000) :while (< y x)] [x y]))


(defn foo [a]
  (fn [b]
    [a b]))

((foo #{1 2 3}) #{4 5})

(defn make-cartesian-product [a b]
  (let [c (vec a)
        d (vec b)
        e [c d]]
    #{e}))

(make-cartesian-product #{1 2 3} #{4 5})




