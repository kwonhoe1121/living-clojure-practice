(ns clojure-problems.core)

;;7일차

;;Advanced Destructuring
(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))


;;A Half-Truth
(= false (not= false false))
(= true (not= true false))
(= false (not= true))
(= true (not= false true false))
(= false (not= true true true))
(= true (#(boolean (and (some true? %&) (some false? %&))) true true true false))


;;Greatest Common Divisor (GCD)
(= ((fn [a b]
      (if (= b 0)
        a
        (recur (if (> a b) b a) (if (> a b) (mod a b) (mod b a))))) 2 4) 2)
(= ((fn g [a b] (if (= b 0) a (g b (rem a b)))) 10 5) 5)
(= ((fn g [a b] (if (= b 0) a (g b (rem a b)))) 5 7) 1)
(= (#(if (zero? %) %2 (recur (mod %2 %) %)) 1023 858) 33)


;;최대 공약수 구하는 알고리즘
;;나누는수A, 나머지B 
;;나머지가 0이 될때의 나눈 수 A가 최대공약수가 된다.
(defn get-gcd [a b]
  (if (= b 0) 
     a 
     (recur (if (> a b) b a) (if (> a b) (mod a b) (mod b a)))))

(get-gcd 1023 858)

(defn get-gcd-adv [a b]
  (if (= b 0) 
     a 
     (recur b (mod a b))))

(get-gcd-adv 1023 858)

