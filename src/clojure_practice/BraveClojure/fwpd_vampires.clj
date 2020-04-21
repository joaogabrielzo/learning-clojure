(ns clojure-practice.BraveClojure.fwpd-vampires)

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
      "Transforms a string of a number into a Integer type"
  [str-num]
  (Integer. str-num))

(def conversions {:name          identity
                  :glitter-index str->int})

(defn convert
      "Takes a :key and a value and converts the value"
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
      "Parses the csv and returns a list of vectors containing [name index]"
  [row]
  (map #(clojure.string/split % #",")
       (clojure.string/split row #"\n")))

(def vt (parse (slurp filename)))

(defn mapify
      "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-rows]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-rows)))
       rows))

(println "rows =" (first vt))

; First, map creates a seq of key-value pairs like ([:name "Bella Swan"] [:glitter-index 0]).
; Then, reduce builds up a map by associating a vamp key with a converted vamp value into row-map.

(println "primeiro map de mapify =" (map vector vamp-keys (first vt)))
(def first-map (map vector vamp-keys (first vt)))
(println "reduce do mapify =" (reduce (fn [row-map [vamp-key value]]
                                        (assoc row-map vamp-key (convert vamp-key value))) {} first-map))

(println "\n")

(println "teste zipmap" (zipmap vamp-keys (first vt)))

(println "\n")

;Exercises

;get a list of names from the suspects list
(def suspects-list (mapify (parse (slurp filename))))

(println (map :name suspects-list))

;create a function to add a new suspect to the list
(defn add-suspect
      "Add a suspect to the list"
  [suspect]
  (conj suspects-list suspect))

(println (add-suspect {:name "Zó" :glitter-index 8000}))

;validate whether a suspect contains the right :keys
(defn validate-suspect
      "Validate if the suspect to be added has the correct :keys"
  ([suspect] (validate-suspect vamp-keys suspect))
  ([right-keys suspect] (= right-keys (keys suspect))))

(println (validate-suspect {:name "Zó" :glitter-index 8000}))
(println (validate-suspect {:zo "name" :8000 "glitter-index"}))

;transform the list of suspects back to csv
(defn back-to-csv
      "Transforms the list of suspect maps back to .csv"
  [suspects]
  (let [rows        (map vals suspects)
        mapped-rows (map (partial clojure.string/join ", ") rows)]
    (clojure.string/join "\n" mapped-rows)))

(println (back-to-csv suspects-list))
