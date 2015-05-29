(ns dice.pages.roll
  (:require [dice.store :refer [get-result re-roll get-throw-number]]))

(defn result-item [r]
  [:div.dice.m {:class (:color r)}
   [:span.number (:number r)]])

(defn result-pair [rpair]
  [:div.dice-row
   (doall (map result-item rpair))])

(defn page []
  (if (nil? (get-result))
    (re-roll))
  (fn []
    [:div.main-content
     [:h2.main-title "Throw " (get-throw-number)]
     ;; [:div.dice-row.blue [:div.dice.xl [:span.number "5"]]]
     (let [result (get-result)
           n (count result)]
       (js/console.log (str result))
       (doall (map result-pair (partition 2 2 nil result))))

     [:div.footer-actions.c3-col
      [:a.btn.btn-primary {:href "#/"} [:span.fa.fa-angle-left] [:span "Back"]]
      " "
      [:a.btn.btn-secondary {:href "#/roll"
                             :on-click re-roll} [:span "REROLL"]]
      " "
      [:a.btn.btn-terciary {:href "#/log"} [:span "LOG"]]]]))
