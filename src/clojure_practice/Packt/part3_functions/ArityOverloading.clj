(ns clojure-practice.Packt.part3-functions.ArityOverloading)

(defn no-overloading
      []
  (println "Anything really"))

(defn overloading
      "Função que pode ter 0 até 2 argumentos"
  ([] (println "Nenhum argumento"))
  ([a] (println (str "Um argumento: " a)))
  ([a b] (println (str "Dois argumentos: " a b))))

(overloading)
(overloading 1)
(overloading 1 2)

;também pode ser recursivo
(defn rec-overloading
      "Função que chama a si própria caso não seja passado argumento"
  ([] (rec-overloading "Recursivo"))
  ([a] (println (str "Overload " a))))

(rec-overloading)

(println "\t")

(def weapon-damage {:fist 5 :club 10 :sword 15 :axe 20})

(defn attack
      "Função de ataque num jogo RPG"
  ([enemy] (attack enemy :fist))
  ([enemy weapon]
    (let [damage (weapon weapon-damage)]
      (update enemy :health - damage))))

(println (attack {:enemy "Troll" :health 90}))
(println (attack {:enemy "Cyclops" :health 120} :axe))