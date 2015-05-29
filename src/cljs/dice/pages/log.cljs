(ns dice.pages.log
  (:require [dice.state :refer [state]]))

(defn get-log []
  (get-in @state [:data :log] []))

(defn clear-log []
  (swap! state assoc-in [:data :log] []))

(defn die-item [d]
  [:li [:div.dice.xsm {:class (:color d)}
        [:span.number (:number d)]]])

(defn result-item [re i]
  [:ul
   [:li i]
   (doall (map die-item re))])

(defn clear-button [e &r]
  (.preventDefault e)
  (clear-log))

(defn page []
  [:div.main-content
   [:h2.main-title "Throws"]
   (doall (map result-item (get-log) (range)))
   [:div.footer-actions
    [:a.btn.btn-primary {:href "#/roll"} [:span.fa.fa-angle-left] "Back"]
    [:a.btn.btn-secondary {:href "#" :on-click clear-button} "Clear"]]])
