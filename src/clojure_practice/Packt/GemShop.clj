(ns clojure-practice.Packt.GemShop)


(def gemstone-db {
                  :ruby       {
                               :name       "Ruby"
                               :stock      120
                               :sales      [1990 3644 6376 4918 7882 6747 7495 8573 5097 1712]
                               :properties {
                                            :dispersion       0.018
                                            :hardness         9.0
                                            :refractive-index [1.77 1.78]
                                            :color            "Red"
                                            }
                               }
                  :diamond    {
                               :name       "Diamond"
                               :stock      10
                               :sales      [8295 329 5960 6118 4189 3436 9833 8870 9700 7182 7061 1579]
                               :properties {
                                            :dispersion       0.044
                                            :hardness         10
                                            :refractive-index [2.417 2.419]
                                            :color            "Typically yellow, brown or gray to colorless"
                                            }
                               }
                  :moissanite {
                               :name       "Moissanite"
                               :stock      45
                               :sales      [7761 3220]
                               :properties {
                                            :dispersion       0.104
                                            :hardness         9.5
                                            :refractive-index [2.65 2.69]
                                            :color            "Colorless, green, yellow"
                                            }
                               }
                  }
  )

;retorna :hardness de um jeito esquisito
(println (:hardness (:properties (:ruby gemstone-db))))

;retorna :hardness de um jeito mais simples
(println (get-in gemstone-db [:ruby :properties :hardness]))

;função para retornar o :hardness de uma `gem`
(defn durability [db gemstone]
  (get-in db [gemstone :properties :hardness]))

(println (durability gemstone-db :ruby))

;faz um update na :color de ruby
(println (assoc (:ruby gemstone-db)
           :properties {:color "Near colorless through pink through all shades of red to a deep crimson"}))

;a forma acima faz o update em todo Map de :properties.
;abaixo vai fazer só o update em :color e retornar o Map completo
(println (update (:ruby gemstone-db)
                 :properties into {:color "Near colorless through pink through all shades of red to a deep crimson"}))

;usar update e into não é tão legível, e retorna apenas ruby.
;a função `assoc-in` é mais indicada pra fazer esse update e retornar o "db" completo.
(println
  (assoc-in gemstone-db [:ruby :properties :color]
            "Near colorless through pink through all shades of red to a deep crimson"))

;função para mudar a cor de uma `gem`
(defn change-color [db gem new-color]
  (assoc-in
    db [gem :properties :color] new-color))

(println (change-color gemstone-db :ruby "blue"))

;retira 1 item do estoque.
(println (update-in gemstone-db [:ruby :stock] dec))

;adiciona uma venda para a `gem`
(println (update-in gemstone-db [:ruby :sales] conj 999))

;função para venda de uma `gem`
(defn sell [db gem client-id]
  (let [clients-updated-db (update-in db [gem :sales] conj client-id)]
    ;é preciso usar let pq é uma função pura. Se não usasse geraria 2 outputs diferentes, e retornaria só o último.
  (update-in clients-updated-db [gem :stock] dec)))

(println (sell gemstone-db :ruby 666))