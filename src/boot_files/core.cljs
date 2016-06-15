(ns boot-files.core
  (:require-macros [rum.core :as rum])
  (:require [rum.core :as rum]))

(rum/defc root
  []
  [:div "hey ho"])






(defn main
  []
  (rum/mount (root) (.querySelector js/document "#app")))