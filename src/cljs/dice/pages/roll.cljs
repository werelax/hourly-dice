(ns dice.pages.roll
  (:require [dice.store :refer [get-result re-roll get-throw-number]]))

(defn result-item [r]
  [:div.dice-row {:class (:color r)}
   [:div.dice.sm
    [:span.number (:number r)]]])

(defn page []
  (if (nil? (get-result))
    (re-roll))
  (fn []
    [:div.main-content
     [:h2.main-title "Throw " (get-throw-number)]
     ;; [:div.dice-row.blue [:div.dice.xl [:span.number "5"]]]
     (doall (map result-item (get-result)))
     [:div.footer-actions.c3-col
      [:a.btn.btn-primary {:href "#/"} [:span.fa.fa-angle-left] "Back"]
      [:a.btn.btn-secondary {:href "#/roll"
                             :on-click re-roll} "REROLL"]
      [:a.btn.btn-terciary {:href "#/log"} "LOG"]]]))
