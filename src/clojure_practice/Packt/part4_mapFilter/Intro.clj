(ns clojure-practice.Packt.part4-mapFilter.Intro)

(println (map #(str % ": " (count %)) ["primeira" "segunda" "terceira" "palavra"]))
;map passa por todos os itens de uma collection e transforma de algum jeito. Retorna uma lista

(println (filter keyword? ["a" :b "b" :c "c" :d :d "e"] ))
;filter passa por todos os itens da collection e retorna só o que for true.

(println (filter odd? [1 2 3 4 5 6 7]))

(println (remove odd? [1 2 3 4 5 6 7]))                     ;faz o contrário de filter

(println (filter (constantly true) [1 2 3 4]))
