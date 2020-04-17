(ns clojure-practice.Packt.part3-functions.AssociativeDestructuring)

(def mapjet-booking
  {
   :id             8773
   :customer-name  "Alice Smith"
   :catering-notes "Vegetarian on Sundays"
   :flights        [
                    {
                     :from {:lat 48.9615 :lon 2.4372 :name "Paris Le Bourget Airport"},
                     :to   {:lat 37.742 :lon -25.6976 :name "Ponta Delgada Airport"}},
                    {
                     :from {:lat 37.742 :lon -25.6976 :name "Ponta Delgada Airport"},
                     :to   {:lat 48.9615 :lon 2.4372 :name "Paris Le Bourget Airport"}}
                    ]
   })

(let [{:keys [customer-name flights]} mapjet-booking]
  (println (str customer-name " booked " (count flights) " flights.")))

(defn print-mapjet-flights [flight]
  (let [{:keys [from to]} flight
        {lat1 :lat long1 :lon} from
        {lat2 :lat long2 :lon} to]
    (println (str "Flying from: Lat " lat1 " Lon " long1 " Flying to: Lat " lat2 " Lon " long2))))

(print-mapjet-flights (first (:flights mapjet-booking)))


(defn print-mapjet-flights2 [flight]
  (let [{{lat1 :lat lon1 :lon} :from
         {lat2 :lat lon2 :lon} :to} flight]
    (println (str "Flying from: Lat " lat1 " Lon " lon1 " Flying to: Lat " lat2 " Lon " lon2))))

(print-mapjet-flights2 (last (:flights mapjet-booking)))


(defn final-print
      [booking]
  (let [{:keys [customer-name flights]} booking]
    (println (str customer-name " booked " (count flights) " flights."))
    (let [[flight1 flight2] flights]
      (when flight1 (print-mapjet-flights flight1))
      (when flight2 (print-mapjet-flights flight2)))))

(final-print mapjet-booking)