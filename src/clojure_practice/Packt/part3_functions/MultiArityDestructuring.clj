(ns clojure-practice.Packt.part3-functions.MultiArityDestructuring)

(def weapon-damage {:fist 5 :club 10 :sword 15 :axe 20})

(defn strike
      "Strike the enemy with an attack"
  [target weapon]
  (let [points (weapon weapon-damage)]
    (if (= :gnome (:camp target))
      (update target :health + points)
      (update target :health - points)))
  )

(let [enemy {:name "Bichão" :health 75 :camp :trolls}]
  (println (strike enemy :axe)))

(let [ally {:name "Lula" :health 115 :camp :gnome}]
  (println (strike ally :club)))

(defn strike-armor
      "Strike an opponent but checks if it has an armor"
  [{:keys [camp armor] :or {armor 0} :as target} weapon]
  (let [points (weapon weapon-damage)]
    (if (= :gnome camp)
      (update target :health + points)
      (let [damage (* points (- 1 armor))]
        (update target :health - damage)))))

(let [enemy {:name "Oto Bichão" :health 105 :camp :troll :armor 0.8}]
  (println (strike-armor enemy :club)))

