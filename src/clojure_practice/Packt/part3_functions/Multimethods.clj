(ns clojure-practice.Packt.part3-functions.Multimethods)

(defmulti strike (fn
                   [{{:keys [:health]} :target weapon :weapon}]
                   (if (< health 20) :finisher weapon)))

(defmethod strike :sword
  [{{:keys [:health]} :target}]
  (- health 100))

(defmethod strike :chute
  [{{:keys [:health]} :target}]
  (- health 100 (rand-int 50)))

(defmethod strike :finisher
  [_]
  0)

(defmethod strike :default
  [{{:keys [:health]} :target}]
  health)


(let [attack {:weapon :sword :target {:health 130}}]
  (println (strike attack)))

(let [attack {:weapon :soquinho :target {:health 29}}]
  (println (strike attack)))


(def player {:name "Zó" :health 200 :weapon :chute :position {:x 10 :y 10 :facing :north}})

(defmulti move (comp :facing :position))

(defmethod move :north
  [entity]
  (update-in entity [:position :y] inc))

(defmethod move :south
  [entity]
  (update-in entity [:position :y] dec))

(defmethod move :west
  [entity]
  (update-in entity [:position :x] dec))

(defmethod move :east
  [entity]
  (update-in entity [:position :x] inc))

(defmethod move :default
  [entity]
  entity)