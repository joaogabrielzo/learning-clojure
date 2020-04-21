(ns clojure-practice.Packt.part4-mapFilter.take-drop)

(println (take 3 [1 2 3 4 5 6]))                            ;take retorna os x primeiros itens da collection

(println (drop 3 [1 2 3 4 5 6]))                            ;drop dropa os x primeiros itens da collection

(println (take-while #(< % 4) [1 2 3 4 5 6]))               ;take-while retorna os itens enquanto forem true

(println (drop-while #(< % 4) [1 2 3 4 5 6]))               ;drop-while dropa os itens enquanto forem true


(def students [{:name "Eliza" :year 1994}
               {:name "Salma" :year 1995}
               {:name "Jodie" :year 1997}
               {:name "Kaitlyn" :year 2000}
               {:name "Alice" :year 2001}
               {:name "Pippa" :year 2002}
               {:name "Fleur" :year 2002}])

(println (take-while #(< (:year %) 2000 students)))

(println (drop-while #(< (:year %) 2000 students)))