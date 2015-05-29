(ns dice.pages.admin
  (:require [dice.state :refer [state]]))

(defn page []
  [:div.main-content
   [:h2.main-title "Choose a dice"]
   [:div.dice-row.blue
    [:a.dice {:href "#"} [:span.number "5"]]
    [:a.color {:href "#"} [:span "blue"]]
    [:div.close [:a {:href "#"} [:span.fa.fa-close]]]]
   [:div.dice-row.green
    [:a.dice {:href "#"} [:span.number "5"]]
    [:a.color {:href "#"} [:span "green"]]
    [:div.close [:a {:href "#"} [:span.fa.fa-close]]]]
   [:div.footer-actions
    [:a.btn.btn-primary {:href "#"} "ADD"]
    [:a.btn.btn-secondary {:href "#/roll"} "ROLL"]]])
