(ns dice.pages.log
  (:require [dice.state :refer [state]]))

(defn page []
  [:div.main-content
   [:h2.main-title "Throws"]
   [:ul
    [:li "1"]
    [:li [:div.dice.blue.xsm [:span.number "1"]]]
    [:li [:div.dice.green.xsm [:span.number "3"]]]
    [:li [:div.dice.orange.xsm [:span.number "6"]]]]
   [:ul
    [:li "2"]
    [:li [:div.dice.orange.xsm [:span.number "1"]]]
    [:li [:div.dice.green.xsm [:span.number "3"]]]
    [:li [:div.dice.blue.xsm [:span.number "6"]]]]
   [:ul
    [:li "3"]
    [:li [:div.dice.blue.xsm [:span.number "1"]]]
    [:li [:div.dice.green.xsm [:span.number "3"]]]
    [:li [:div.dice.orange.xsm [:span.number "6"]]]]
   [:div.footer-actions
    [:a.btn.btn-primary {:href "#/roll"} [:span.fa.fa-angle-left] "Back"]
    [:a.btn.btn-secondary {:href "#"} "Clear"]]])
