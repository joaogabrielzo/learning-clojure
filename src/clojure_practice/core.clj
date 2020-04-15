(ns clojure-practice.core
  (:require [clojure.string :as str]))

(defn testMult [x] (* x x))

(println (testMult 9))

(println (meditate "Eu to calmo" false))

(println (and "hello" false))                               ;and returns the first falsey value
(println (or "hello" true))                                 ;or returns the first truthy value

(if
  (and (> 3 2) (< 2 3))
  (println "ok")
  (println "ko"))

(let [x 50]
  (if (or (<= 1 x 100) (mod x 100))
    (println "Valid")
    (println "Invalid")))