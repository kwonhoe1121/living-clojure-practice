(ns clojure-problems.core)

;;10일차

;;;Pascal's Triangle

(= (#(get-pascal-triangle-row %) 1) [1])

(= (map #(get-pascal-triangle-row %) (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])

(= (#(get-pascal-triangle-row %) 11) 
   [1 10 45 120 210 252 210 120 45 10 1])


(get-pascal-triangle-row 1)
(map get-pascal-triangle-row (range 1 6))
(get-pascal-triangle-row 11)

;;파스칼 삼각형 규칙
;;첫 번째 행은 1이다.
;;다음 행은 바로 위의 행의 인접한 두 수를 더해 계산한 다음 행의 처음과 마지막에 1을 추가한다.

;;파스칼 삼각형 행 만드는 함수
(defn make-pascal-row [prev-row]
  (loop [in prev-row
         out [1]]
    (if (< (count in) 2)
      (conj out 1)
      (recur (rest in)
             (conj out (+ (first in) (second in)))))))

(#(make-pascal-row %) [1 3 3 1])

;;파스칼 삼각형 만드는 함수
(defn make-pascal-triangle [limit-num]
  (take limit-num (iterate make-pascal-row [1])))

(make-pascal-triangle 10)

;;파스칼 삼각형에서 n번째 함수 반환하는 함수.
(defn get-pascal-triangle-row [num]
  (last (make-pascal-triangle num)))

(get-pascal-triangle-row 10)


;;참고 답안.
(fn [n]
    (last (take n (iterate #(map +' `(0 ~@%) `(~@% 0)) [1])))) [1]


(fn [n]
  (reduce 
    (fn [c k] (conj c (* (/ (- (dec n) k) 
                            (inc k)) 
                         (last c))))
    [1]
    (range (dec n))))


(fn pascal [n]
  (loop [i 1, row [1]]
    (if (= n i) 
      row
      (recur (inc i) (concat [1] (map #(apply + %) (partition 2 1 row)) [1])))))


(partition 2 1 [1 3 3 1])
(map #(apply + %) (partition 2 1 [1 3 3 1]))
(concat [1] (map #(apply + %) (partition 2 1 [1 3 3 1])) [1])







