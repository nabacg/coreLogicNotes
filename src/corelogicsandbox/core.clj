(ns corelogicsandbox.core
  (:require [clojure.core.logic :as l :refer :all]))


(run 1 [q]
  (== q 1))

(run 1 [q]
  (fresh [v2]
    (== v2 1)
    (== v2 q)))

(run* [q]
  (membero q [1 2 3 4])
  (membero q [3 4 5]))

(run* [q]
  (== {:a q :b 23} {:a 42 :b 23}))

(run 1 [q]
  (fresh [x]
    (== x 2)
    (project [x]
             (== q (* x x)))))


(run 2 [q]
  (conde
   ((== q 1) )
   (fail)
   (succeed (== q 23))))

(defn succ [p n]
  (conso p [] n))

(def zero 0)
(def one '(0))

(run 1 [q]
  (succ zero q))

(run 1 [q]
  (succ q one))

(defn natural-number [x]
  (conde
   ((== x zero))
   ((fresh [prev]
      (succ prev x)
      (natural-number prev)))))

(run 1 [q]
  (natural-number one))

(run 6 [q]
  (natural-number q))
