(ns clojure-practice.Packt.part3-functions.HigherOrderFunctions)

(def weapon-fn-map
  {:fist (fn [health] (if (< health 100) (- health 10) health))
   :staff (partial + 35)
   :sword #(- % 100)                                        ;#( % ) é syntactic sugar pra funções anônimas
   :chute #(- % 100 (rand-int 50))
   :banana identity})

(defn strike
      "Strike the enemy with an weapon"
  ([enemy] (strike enemy :fist))
  ([enemy weapon]
   (let [weapon-fn (weapon weapon-fn-map)]
     (update enemy :health weapon-fn))))

(println (strike {:name "Zó" :health 70}))

(defn all-strike
      "Strike with all weapon at once"
  [enemy]
  (let [weapon-fn (apply comp (vals weapon-fn-map))]
    (update enemy :health weapon-fn)))

(println (all-strike {:name "Bicho" :health 300}))