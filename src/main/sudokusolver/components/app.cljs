(ns sudokusolver.components.app
  (:require
   [sudokusolver.components.sudokuboard :refer [board]]
   [sudokusolver.components.title :refer [title]]))

(defn app []
  [:div#app
   [title "sudoku solver"]
   [board 9 9]])
