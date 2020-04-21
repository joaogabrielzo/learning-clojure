(ns clojure-practice.Packt.part4-mapFilter.different-map-functions
  (:require [clojure.string :as str]))

(def alpha-lc [ "a" "b" "c" "d" "e" "f" "g" "h" "i" "j"])

(println "map: " (map #(vector % (str/upper-case %)) alpha-lc))
(println "mapcat: " (mapcat #(vector % (str/upper-case %)) alpha-lc)) ;tipo um flatmap de sequences
(println "zipmap: " (zipmap [:a :b :c] ["a" "b" "c"]))      ;zipa 2 inputs em um map, :key-value

(def itens ["colher" "cerular" "canetinha" "caneca"])       ;tudo com C foi coincidência
(println (map-indexed (fn [index item] (str (inc index) ". " item)) itens)) ;indexa uma lista de itens

(defn fib
      "fibonacci"
  ([n] (fib n 2 [0 1]))
  ([n-max n-init fib-init]
    (if (= n-max n-init)
      fib-init
      (let [last (last fib-init)
            second-last (first (rest (reverse fib-init)))
            next-n (+ last second-last)]
        (fib n-max (+ n-init 1) (conj fib-init next-n))))))

(println (fib 8))