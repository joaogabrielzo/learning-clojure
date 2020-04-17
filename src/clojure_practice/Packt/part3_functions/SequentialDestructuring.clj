(ns clojure-practice.Packt.part3-functions.SequentialDestructuring)

(def booking [1425,
              "Bob Smith",
              "Allergic to unsalted peanuts only",
              [[48.9615, 2.4372], [37.742, -25.6976]],
              [[37.742, -25.6976], [48.9615, 2.4372]]]
  )

(let [[id passenger info flight-go flight-back] booking]
  (println id passenger flight-go flight-back))

(let [big-booking (conj booking [[37.742, -25.6976], [51.1537, 0.1821]] [[51.1537, 0.1821], [48.9615, 2.4372]])
      [id customer-name sensitive-info flight1 flight2 flight3] big-booking]
  (println id customer-name flight1 flight2 flight3))

(let [[_ customer-name _ flight1 flight2 flight3] booking]  ;_ ignora o campo no qual ele está posicionado
  (println customer-name flight1 flight2 flight3))

(let [[_ customer _ & flights] booking]                     ;& transforma todos os parâmetros que vêm depois num vetor
  (println (str customer " booked " (count flights) " flights.")))

(defn print-flight [flight]
  (let [[from to] flight
        [lat1 lon1] from
        [lat2 lon2] to]
    (println (str "Flying from: Lat " lat1 " Lon " lon1
                  "\nto: Lat " lat2 " Lon " lon2))))

(print-flight [[37.742, -25.6976], [51.1537, 0.1821]])

(println "\n")

(defn print-booking
      [booking]
  (let [[_ customer _ & flights] booking]
    (println (str customer " booked " (count flights) " flights."))
    (let [[flight1 flight2] flights]
      (when flight1 (print-flight flight1))
      (when flight2 (print-flight flight2)))))

(print-booking booking)