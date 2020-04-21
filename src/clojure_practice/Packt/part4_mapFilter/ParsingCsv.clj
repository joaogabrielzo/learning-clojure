(ns clojure-practice.Packt.part4-mapFilter.ParsingCsv
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(with-open [r (io/reader "/home/zo/dev/Clojure/clojure-practice/resources/match_scores_2010-2019.csv")]
  (println (count (csv/read-csv r))))
