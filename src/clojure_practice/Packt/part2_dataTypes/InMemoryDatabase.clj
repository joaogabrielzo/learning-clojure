(ns clojure-practice.Packt.part2-dataTypes.InMemoryDatabase)

(def memory-db (atom {}))
(defn read-db [] @memory-db)
(defn write-db [new-db] (reset! memory-db new-db))
;formato dos dados:
;{:table-1 {:data [] :indexes {}} :table-2 {:data [] :indexes {}}

;cria um novo db
(println (write-db {:clientes {:data [] :indexes {}}}))


(defn create-table
      "função para criar uma tabela no db. `conj` retorna o Map com a :key adicionada"
  [table-name]
  (let [db (read-db)]
    (write-db (assoc db table-name {:data [] :indexes {}}))))

(create-table :estoque)
(println (read-db))


(defn drop-table
      "função para retirar uma tabela. `dissoc` retorna o Map sem a :key passada"
  [table-name]
  (let [db (read-db)]
    (write-db (dissoc db table-name))))

(drop-table :clientes)
(println (read-db))


(defn insert
      "função para inserir uma linha no db"
  [table value id]
  (let [db     (read-db)
        new-db (update-in db [table :data] conj value)
        index  (- (count (get-in new-db [table :data])) 1)]
    (write-db
      (update-in new-db [table :indexes id] assoc (id value) index))))

(insert :estoque {:item "banana" :qtd 10} :item)
(insert :estoque {:item "maçã" :qtd 3} :item)
(println (read-db))


(defn select-*
      "função para selecionar todos os itens de uma tabela"
  [table-name]
  (let [db (read-db)]
    (get-in db [table-name :data])))

(println (select-* :estoque))


(defn select-*-where
      "função para selecionar todos os itens com uma condição"
  [table field value]
  (let [db    (read-db)
        index (get-in db [table :indexes field value])      ;busca em :indexes, que é um Map, a key = "value",
        data  (get-in db [table :data])]                    ;e retorna o seu numero de index.
    (get data index)))                                      ;como :data é um array, vai buscar o item pelo index

(println (select-*-where :estoque :item "banana"))          ;"banana" tem index 0 em :indexes, então busca o primeiro item de :data

(println (sorted-set [6 6] [:a :b :c] ["A"] [1 1]))