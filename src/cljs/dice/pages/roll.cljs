(ns dice.pages.roll
  (:require [dice.state :refer [state]]))

(defn page []
  [:div.main-content
   [:h2.main-title "Throw 24"]
   [:div.dice-row.blue [:div.dice.xl [:span.number "5"]]]
   [:div.dice-row.green [:div.dice.sm [:span.number "6"]]]
   [:div.dice-row.orange [:div.dice.sm [:span.number "3"]]]
   [:div.footer-actions.3-col
    [:a.btn.btn-primary {:href "#/"} [:span.fa.fa-angle-left] "Back"]
    [:a.btn.btn-secondary {:href "#"} "REROLL"]
    [:a.btn.btn-terciary {:href "#/log"} "LOG"]]])
