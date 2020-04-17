(ns clojure-practice.Packt.part1-hello.predictCO2)

(def base-co2 382)
(def base-year 2006)

(defn co2-estimate
      "Returns a given year's estimative of carbon dioxide parts per million in the atmosphere"
  [year]
  (let [yearDiff (- year base-year)]
    (+ base-co2 (* yearDiff 2))))

(println (co2-estimate 2050))