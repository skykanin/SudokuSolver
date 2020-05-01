(ns sudokusolver.app
  (:require [reagent.dom :as rdom]
            [sudokusolver.components.app :refer [app]]))

(defn render []
  (rdom/render app (.getElementById js/document "root")))

(defn ^:dev/after-load main []
  (render))
