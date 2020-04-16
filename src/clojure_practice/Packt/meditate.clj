(ns clojure-practice.Packt.meditate
  (:require [clojure.string :as str]))

(defn meditate
      "Meditation"
  [s calm]
  (println "Clojure Medidate v1.0.0")
  (if calm
    (str/capitalize s)
    (str (str/upper-case s) "!")))

(println (meditate "i am calm" false))

(defn meditate2
      "Better meditation"
  [s calmness-level]
  (println "Clojure Meditate v2.0.0")
  (cond
    (< calmness-level 5) (str (str/upper-case s) ", I TELL YOU")
    (and (>= calmness-level 5) (<= calmness-level 9)) (str/capitalize s)
    :else (str/reverse s)
    ))

(println (meditate2 "testing" 1))
(println (meditate2 "testing" 6))
(println (meditate2 "testing" 10))
