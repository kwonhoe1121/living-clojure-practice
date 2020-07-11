(ns clojure-problems.core)

;;5일차

;;Compress a Sequence
;;시퀀스에서 두개의 값을 가져온다.
;;두개의 값을 비교한다.
;;다르면 앞의 수를 결과값에 추가시킨다.
(= (#(reduce (fn [r x] (if (not= (last r) x) (conj r x) r)) [] %) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (#(map last (partition-by list %)) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (#(map first (partition-by identity %)) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

(partition-by list [1 1 2 3 3 2 2 3])
(partition-by identity [1 1 2 3 3 2 2 3])
(identity [1 1 2 3 3 2 2 3])



;;Pack a Sequence

(= (#(partition-by list %) [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= ((fn p 
       ([[h & t]] (p [] [h] t))
        ([a h t] 
            (if-let [[f & n] t]
                   (if (= (first h) f)
                            (p a (conj h f) n)
                                   (p (conj a h) [f] n))
                        (conj a h)))) [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (partition-by identity [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))


;;Drop Every Nth Item
(= (#(apply concat (partition-all (dec %2) %2 %)) [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (#(apply concat (partition-all (dec %2) %2 %)) [:a :b :c :d :e :f] 2) [:a :c :e])
(= (#(apply concat (partition-all (dec %2) %2 %)) [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; 3개로 쪼갠 다음 다시 2로 쪼개면 3의 배수번 째 요소 값이 사라진다.
(partition-all 3 [1 2 3 4 5 6 7 8])
(partition-all 2 3 [1 2 3 4 5 6 7 8])
(partition 2 3 [1 2 3 4 5 6 7 8])

(#(apply concat (partition-all (dec %2) %2 %)) [1 2 3 4 5 6 7 8] 3)

#(apply concat (partition-all (dec %2) %2 %))


;;Intro to Iterate

(=[1 4 7 10 13] (take 5 (iterate #(+ 3 %) 1)))
(=(range 1 14 3) (take 5 (iterate #(+ 3 %) 1)))

(take 5 (iterate #(+ 3 %) 1))



;;Replicate a Sequence
(= (#(comp cat cat (map (fn [x] (conj (list x) x)) (partition 1 %1))) [1 2 3] 2) '(1 1 2 2 3 3))
(= ((fn [s n] (mapcat #(repeat n %) s)) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= ((fn [s n] (mapcat #(repeat n %) s)) [4 5 6] 1) '(4 5 6))
(= (#(mapcat (partial repeat %2) %) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= ((fn [s n] (mapcat #(repeat n %) s)) [44 33] 2) [44 44 33 33])



(= ( [1 2 3] 2) '(1 1 2 2 3 3))

(take 2 (range 1 10))
(partition 1 [1 2 3])
(map (fn [x] (conj x x)) (partition 1 [1 2 3]))
(map (fn [x] (conj x x)) (partition 1 [1 2 3]))
(apply concat (map (fn [x] (conj x x)) (partition 1 [1 2 3])))
(apply concat (map (fn [x] (conj (list x) x)) (partition 1 [1 2 3])))

(comp cat cat (map (fn [x] (conj (list x) x)) (partition 1 [1 2 3])))
(comp cat cat (map (fn [x] (conj (list x) x)) (partition 1 [1 2 3])))

(partition-all 1 [1 2 3])
;; cat is handy for untangling nested collections when using transducers
(into [] (comp cat cat) (map (fn [x] (conj (list x) x)) (partition 1 [1 2 3])))

(fn [s n] (mapcat #(repeat n %) s))



(repeat 2 [1])
(mapcat (repeat 2 [1 2 3]) [1 2 3])







