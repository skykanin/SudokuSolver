(ns sudokusolver.components.sudokuboard
  (:require [reagent.core :as r]))

(def input-attr
  {:type "text"
   :pattern "[1-9]"
   :size 2
   :max-length 1})

(defn board [rows columns]
  [:div#container
   (for [group (range rows)]
     ^{:key group}
     [:div.group
      (for [column (range columns)]
        ^{:key column}
        [:div.element
         [:input input-attr]])])])
