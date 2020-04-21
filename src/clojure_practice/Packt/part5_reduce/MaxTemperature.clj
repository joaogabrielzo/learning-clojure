(ns clojure-practice.Packt.part5-reduce.MaxTemperature)

(def weather-days
  [{:max         31
    :min         27
    :description :sunny
    :date        "2019-09-24"}
   {:max         28
    :min         25
    :description :cloudy
    :date        "2019-09-25"}
   {:max         22
    :min         18
    :description :rainy
    :date        "2019-09-26"}
   {:max         23
    :min         16
    :description :stormy
    :date        "2019-09-27"}
   {:max         35
    :min         19
    :description :sunny
    :date        "2019-09-28"}])

(println (reduce (fn [past-days today]
                   (if (> (:max today) (:max past-days))
                     today
                     past-days))
                 weather-days))

(println (reduce (fn [past-days today]
                   (if (< (:max today) (:max past-days))
                     today
                     past-days))
                 weather-days))