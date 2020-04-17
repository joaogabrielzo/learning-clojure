(ns clojure-practice.Packt.part3-functions.DistanceCostCalculator)

(def paris {:lat 48.856483 :lon 2.352413})
(def bordeaux {:lat 44.834999 :lon -0.575490})

(def london {:lat 51.507351, :lon -0.127758})
(def manchester {:lat 53.480759, :lon -2.242631})

(def walking-speed 4)
(def driving-speed 70)

(defn distance
      "Calculates the distance between two points"
  [{lat1 :lat lon1 :lon} {lat2 :lat lon2 :lon}]
  (let [defnum 110.25
        x      (- lat2 lat1)
        y      (* (Math/cos lat2) (- lon2 lon1))]
    (* defnum (Math/sqrt (+ (* x x) (* y y))))))

(defmulti itinerary :transport)

(defmethod itinerary :walking
  [{from :from to :to}]
  (let [dist (distance from to)
        time (/ dist walking-speed)]
    {:cost 0 :distance dist :duration time}))

(def vehicles-cost {
                    :porsche (partial * 0.12 1.3)
                    :toyota (partial * 0.07 1.3)
                    :tesla (partial * 0.2 0.1)
                    })

(defmethod itinerary :driving
  [{from :from to :to vehicle :vehicle}]
  (let [dist (distance from to)
        car (vehicle vehicles-cost)
        price (car dist)
        time (/ dist driving-speed)]
    {:cost price :distance dist :duration time}))

(println (itinerary {:from london :to manchester :transport :walking}))
(println (itinerary {:from manchester :to london :transport :driving :vehicle :tesla}))
