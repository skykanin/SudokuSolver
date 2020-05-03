(ns sudokusolver.components.sudokuboard
  (:require [clojure.string :refer [split]]
            [cljs.pprint :refer [pprint]]
            [reagent.core :as r]))

(def board-state
  (r/atom (vec (repeat 9 (vec (repeat 9 nil))))))

(add-watch board-state :watcher
  (fn [key atom old-state new-state]
    (prn "-- Atom Changed --")
    (pprint new-state)))

(defn update-board
  "Update board state on user input"
  [evt]
  (let [name (.. evt -target -name)
        value (.. evt -target -value)
        [group cell] (mapv int (split name #" "))]
    (swap! board-state assoc-in [group cell]
           (when-not (empty? value) (int value)))))
    
(defn build-attr
  "Build attribute map for input tags"
  [group cell]
  {:type "text"
   :pattern "[1-9]"
   :size 2
   :max-length 1
   :name (str group " " cell)
   :on-key-up update-board})

(defn board [rows columns]
  [:div#container
   (for [group (range rows)]
     ^{:key group}
     [:div.group
      (for [cell (range columns)]
        ^{:key cell}
        [:div.element
         [:input (build-attr group cell)]])])])
