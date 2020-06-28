(ns clojure-problems.core)

;;2일차


;rest (Sequences:rest)
(= [20 30 40] (rest [10 20 30 40]))

;Intro to Functions
(= 8 ((fn add-five [x] (+ x 5)) 3))

;Double Down
(= ((fn [x] (* 2 x)) 2) 4)
(= (#(* 2 %) 3) 6) 

;Hello World
(= (#(str "Hello, " % "!") "Dave") "Hello, Dave!")
(= (format "Hello, %s!" "Dave") "Hello, Dave!")

;map(Sequences:Maps)
(= [6 7 8] (map #(+ % 5) '(1 2 3)))

;filter (Sequences:filter)
(= [6 7] (filter #(> % 5) '(3 4 5 6 7)))

;Local bindings
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3 y 10] (- y 3)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

