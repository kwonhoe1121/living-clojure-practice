(ns clojure-problems.core)

;;9일차

;;;Symmetric Difference
(= (#(clojure.set/union (clojure.set/difference %1 %2) (clojure.set/difference %2 %1)) #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (#(set `(~@(% %2 %3) ~@(% %3 %2))) remove #{:a :b :c} #{}) #{:a :b :c})
(= ( #{} #{4 5 6}) #{4 5 6})
(= ( #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})


(= (hash-set #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(hash-set #{1 2 3 4 5 6} #{1 3 5 7})
(hash-set #{1 2 3 4 5 6} #{1 3 5 7})
(conj #{1 2 3 4 5 6} #{1 3 5 7})
(conj (vec #{1 2 3 4 5 6}) (vec #{1 3 5 7}))
(into #{} (hash-set #{1 2 3 4 5 6} #{1 3 5 7}))

(vector (vec #{1 2 3 4 5 6}) (vec #{1 3 5 7}))
(map conj (vector (vec #{1 2 3 4 5 6}) (vec #{1 3 5 7})))

(into (set #{1 3 5 7}) #{1 2 3 4 5 6})

;;중복 찾기
((fn [a b] 
     (for [x (vec a) y (vec b) :let [z x] :when (= x y)] z)) #{1 2 3 4 5 6} #{1 3 5 7})

;;중복 제거

;;집합 함수 활용.
(= (#(clojure.set/union (clojure.set/difference %1 %2) (clojure.set/difference %2 %1)) #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(#(clojure.set/difference %1 %2) #{1 2 3 4 5 6} #{1 3 5 7})

;;집합set은 진위 여부로 많이 활용한다.
;;filter 진위 값이 참이면 lazy-seq 반환.
(filter #{1 2 3 4 5 6} #{1 3 5 7})
;;remove 진위 값이 참이면 제거
(remove #{1 2 3 4 5 6} #{1 3 5 7})


;;;Least Common Multiple
(== ((fn [& args] 
        (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))]
             (/ (reduce * args) (reduce gcd args)))) 2 3) 6)

(== ((fn lcm [x & xs]
     (some (fn [y] (if (every? #(zero? (rem y %)) xs) y))
           (iterate #(+ x %) x))) 5 3 7) 105)

(== ((fn [G & n] (reduce #(/ (* % %2) (G % %2)) n))
    (fn g [a b] (if (= b 0) a (g b (rem a b)))) 1/3 2/5) 2)

(== ( 3/4 1/6) 3/2)
(== ( 7 5/7 2 3/5) 210)

;;최소공배수 (lcm) 최대공약수(gcd) 관계
;;lcm (a,b) = |ab|/gcd(a,b)
;;gcd를 (fn [a b] (if (zero? b) a (recur b (mod a b)))) 함수로 맵핑하고 reduce 로 args로 들어오는 인수 2개씩 누적값으로 전체 인수의 최대공약수를 구함
;;데이터 가공 -> map, reduce, filter, remove 사용
(fn [& args] 
    (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))]
          (/ (reduce * args) (reduce gcd args))))

(defn gcd-test [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

((fn [& args]
   (/ (reduce * args) (reduce gcd-test args))) 5 3 7)


(== ( 5 3 7) 105)

(defn get-gcd [a b]
  (if (= b 0) 
     a 
     (recur b (mod a b))))




((fn g [a b] (if (= b 0) a (g b (rem a b)))) 10 5)







