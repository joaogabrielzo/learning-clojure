(ns clojure-practice.Packt.part4-mapFilter.lazyThings)

(defn my-range
      "Faz uma função igual range"
  ([limit] (take-while #(< % limit) (iterate inc 0)))
  ([start limit] (take-while #(< % limit) (iterate inc start))))

(println (my-range 14))
(println (my-range 3 14))

(def by-ten (map (fn [i] (print ".") (* i 10)) (my-range 5)))

(println by-ten)