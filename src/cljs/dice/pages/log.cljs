(ns dice.pages.log
  (:require [dice.store :refer [get-log clear-log]]))

(defn clear-button [e &r]
  (.preventDefault e)
  (clear-log))

(defn die-item [d]
  [:li [:div.dice.xsm {:class (:color d)}
        [:span.number (:number d)]] " "])

(defn result-item [re]
  [:ul.dice-list
   [:li.title (:throw re)]
   " "
   (doall (map die-item (:roll re)))])

(defn page []
  [:div.main-content.log
   [:div.content-wrapper
    [:h2.main-title "Throws"]
    (doall (map result-item (get-log)))]
   [:div.footer-actions.c2-col
    [:a.btn.btn-primary {:href "#/roll"} [:span.fa.fa-angle-left] [:span "Back"]]
    " "
    [:a.btn.btn-secondary {:href "#" :on-click clear-button} [:span "Clear"]]]])
