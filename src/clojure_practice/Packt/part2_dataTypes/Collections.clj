(ns clojure-practice.Packt.part2-dataTypes.Collections)

(def aMap {:first 1 :second 2 :third 3})                    ;maps são como HashMaps normais, definidos como {:key value}

(println (get aMap :second))
(println (get aMap :fourth "Não existe"))
(println (:first aMap))
(println (:fifth aMap "Assim é mais fácil"))

(println (assoc aMap :fourth 4))                            ;assoc retorna um map com valor a mais
(println (assoc aMap :first 10))                            ;assoc também pode retornar com valor mudado
(println (update aMap :first - 10))                         ;update muda o valor com base no valor já existente
(println (dissoc aMap :third))                              ;dissoc retorna um map com valor a menos

(println "\n")

(def aSet #{"dollar" "yen" "euro" "real"})                  ;sets são imutáveis, não mantém ordem e não aceitam duplicados
;os valores em sets são acessados pelo valor em si, não por um index
(println (get aSet "yen"))
(println (contains? aSet "peso"))
(println (aSet "real"))

(println (conj aSet "moeda"))                               ;conj retorna um set com valor a mais
(println (disj aSet "real"))                                ;disj faz o contrário

(println "\n")

(def aVector [1 2 3 4 5 6])                                 ;vector são imutáveis, mantém a ordem na qual são inseridos e aceitam duplicados
;os valores em vectors são acessados por um index, começando do 0
(println (aVector 0))

(def fibonacci [0 1 1 2 3 5 8])

(println (let [size           (count fibonacci)
               last-number    (last fibonacci)
               second-to-last (fibonacci (- size 2))]
           (conj fibonacci (+ last-number second-to-last))))

(def aList '("cat" "dog" "horse" "zebra"))

(println (first aList))                                     ;first aList retorna o Head da lista
(println (rest aList))                                      ;rest aList retorna o Tail da lista
(println (cons "dinosaur" aList))                           ;cons retorna a lista com um item a mais no começo
(println (nth aList 2))                                     ;nth busca um item pelo index (não recomendado)

(println "\n")

(println (into aSet aVector))                               ;into insere a collection da direta na esquerda
(println (into aList aVector))                              ;como list é uma pilha, os itens são adicionados na frente

(println (concat aList aVector))                            ;concat faz o mesmo que into, mas mantém a ordem. É mais indicado
;diferente de into, concat não transforma a segunda collection na primeira. Sempre vira tudo uma lista

(println (assoc [:a :b :c :d] 2 :z))                        ;assoc aceita 3 argumentos, e insere o terceiro na posição x da collection
