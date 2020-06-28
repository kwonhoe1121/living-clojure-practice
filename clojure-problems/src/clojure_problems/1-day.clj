(ns clojure-problems.core)

;;1일차

;문자열 소개 (Intro to Strings)
;클로저의 문자열은 자바의 문자열이다. 그래서 클로저 문자열을 다룰 때 자바의 문자열 메소드를 그대로 사요할 수 있다.
(= "HELLO WORLD" (.toUpperCase "hello world"))

;리스트 소개(Intro to Lists)
;리스트 함수나 인용 기호로 생성할 수 있다.
(= (list :a :b :c) `(:a :b :c))

;리스트: conj (Lists: conj)
;conj 함수는 하나의 리스트를 받아서 하나 이상의 요소들을 그 앞부분에 추가한 새 리스트를 반환하다.
(= '(1 2 3 4 5) (conj '(2 3 4 5) 1))
(= (list 1 2 3 4 5) (conj '(3 4 5) 2 1))

;벡터소개 (Intro to Vectors)
;벡터는 여러 가지 방법으로 생성할 수 있다. 벡터는 리스트와 비교할 수 있다.
(= [:a :b :c] 
   (list :a :b :c)
   (vec `(:a :b :c))
   (vector :a :b :c))

;벡터: conj (Vectors: conj)
;conj 함수는 하나의 벡터를 받아서 하나 이상의 요소를 뒷부분에 추가한 새 벡터를 반환한다.
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

;집합 소개 (Intro to Sets)
;집합은 유일한 값들의 컬렉션이다.
(= #{:a :b :c :d} (set '(:a :a :a :a :b :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:d :b :c}))


;집합: conj (Sets: conj)
;conj 함수는 하나의 집합을 받아서 하나 이상의 키를 추가한 새 집합을 반환한다.
(= #{1 2 3 4} (conj #{1 4 3} 2))

;맵 소개 (Intro to Maps)
;맵은 키-값 쌍을 저장한다. 맵과 키워드는 둘 다 요소를 찾는 함수로 사용될 수 있다. 쉼표를 사용해 맵을 읽기 쉽게 할 수는 있지만 필수적인 것은 아니다.
(= 20 ((hash-map :a 10 :b 20 :c 30) :b))
(= 20 (:b {:a 10 :b 20 :c 30}))

;맵:conj (Maps: conj)
;conj 함수는 하나의 맵을 받아서 하나 이상의 키-값 쌍을 추가한 새 맵을 반환한다.
(= {:a 1 :b 2 :c 3} (conj {:a 1} [:b 2] [:c 3]))

;시퀀스 소개 (Intro to Sequences)
;클로저의 모든 컬렉션은 시퀀스 연산을 지원한다. 시퀀스에 second나 last 같은 함수를 적용할 수 이다.
(= 3 (first '(3 2 1)))
(= 3 (last [1 2 3]))
(= 3 (second '(1 3 2)))



