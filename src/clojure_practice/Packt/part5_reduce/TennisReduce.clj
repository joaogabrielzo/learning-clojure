(ns clojure-practice.Packt.part5-reduce.TennisReduce
  (:require
    [clojure.java.io :as io]
    [clojure.data.csv :as csv]
    [semantic-csv.core :as sc]
    [clojure.math.numeric-tower :as math]))

(defn match-probability
      "Each player's probability of winning the match"
  [p1 p2]
  (/ 1
     (+ 1
        (math/expt 10 (/ (- p2 p1) 400)))))

(def k-factor 32)                                           ;the maximum possible points earned per match

(defn recalculate-rating
      "Recalculate a player's rating after a match"
  [previous-rating expected-result real-result]
  (+ previous-rating (* k-factor (- real-result expected-result))))
