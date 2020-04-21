(ns clojure-practice.Packt.part4-mapFilter.map-filter)

(println (map #(* 10 %)
              (filter odd? [1 2 3 4 5 6 7])))

(println (->> [1 2 3 4 5 6 7]                               ;threading macros o nome disso
              (filter odd?)                                 ;faz o código ficar mais legível
              (map #(* 10 %))))                             ;muito doido

