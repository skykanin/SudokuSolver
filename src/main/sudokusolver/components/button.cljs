(ns sudokusolver.components.button
  (:require [sudokusolver.components.sudokuboard :refer [board-state]]
            [sudokusolver.logic :refer [solve]]))

(defn calculate []
  (cljs.pprint/pprint (solve @board-state)))

(defn button [txt]
  [:button {:type "button"
            :on-click calculate} txt])
