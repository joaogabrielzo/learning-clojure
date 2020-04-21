(ns clojure-practice.Packt.part4-mapFilter.WeatherTrends)

(def temperature-by-day
  [18 23 24 23 27 24 22 21 21 20 32 33 30 29 35 28 25 24 28 29 30])

(println (map (fn [today yesterday]
                (cond
                  (> today yesterday) :warmer
                  (< today yesterday) :colder
                  (= today yesterday) :same))
              (rest temperature-by-day)
              temperature-by-day)
         )

(defn avg
      "Gets the mean value of a list"
  [coll]
  (let [sum-coll (apply + coll)
        count-coll (count coll)]
    (float (/ sum-coll count-coll))))

(println (avg temperature-by-day))