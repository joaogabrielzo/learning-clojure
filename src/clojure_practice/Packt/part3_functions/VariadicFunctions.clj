(ns clojure-practice.Packt.part3-functions.VariadicFunctions)

;o & antes do parâmetro faz com que ele se torne uma collection e aceite quantos argumentos for
(defn welcome
      "Welcome players and send friend requests"
  ([player] (println (str "Welcome to The Game, " player)))
  ([player & friends]
  (println (str "Welcome to The Game, " player))
  (when (seq friends)
    (println (str "Sending " (count friends) " friend request(s) to: " (clojure.string/join ", " friends))))
  ))

(welcome "Zó")

