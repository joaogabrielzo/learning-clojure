(ns clojure-practice.Packt.part5-reduce.InitializingReduce)

(println (reduce (fn [{:keys [maximum minimum]} new-number]
                    {:minimum (if (and minimum (> new-number minimum))
                                minimum
                                new-number)
                     :maximum (if (and maximum (< new-number maximum))
                                maximum
                                new-number)})
                 {}                                         ;<- valor inicial
                 [5 5004 892 120 22])
         )
;na função acima é passado um Map vazio pro reduce, então conforme vai avançando na sequência
;ele atualiza o valor das keys :minimum e :maximum quando novos valores são descobertos

(println (reduce (fn [{:keys [segment current] :as accum} n]
                   (let [current-with-n (conj current n)
                         total-with-n (apply + current-with-n)]
                     (if (> total-with-n 20)
                       (assoc accum
                         :segment (conj segment current)
                         :current [n])
                       (assoc accum :current current-with-n))))
                 {:segment [] :current []}
                 [4 19 4 9 5 12 5 3 4 1 1 9 5 18]))