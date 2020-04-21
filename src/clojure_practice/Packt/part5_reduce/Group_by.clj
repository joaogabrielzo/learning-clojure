(ns clojure-practice.Packt.part5-reduce.Group-by
  (:require [clojure.pprint :as pp]))

(def dishes
  [{:name "Carrot Cake"
    :course :dessert}
   {:name "French Fries"
    :course :main}
   {:name "Celery"
    :course :appetizer}
   {:name "Salmon"
    :course :main}
   {:name "Rice"
    :course :main}
   {:name "Ice Cream"
    :course :dessert}])

(pp/pprint (group-by :course dishes))