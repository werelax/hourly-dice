(ns dice.pages.admin
  (:require [dice.store :refer [insert-dice remove-dice rotate-attr
                                get-dices clear-result reset-throw-number]]))

(defn dice-partial [d]
  (let [id (:id d)
        color (-> d :color first str)]
    [:div.dice-row {:class color}
     [:a.dice {:href "#"
               :on-click (partial rotate-attr :sides id)}
      [:span.number (first (:sides d))]]
     [:a.color {:href "#"
                :on-click (partial rotate-attr :color id)}
      [:span color]]
     [:div.close [:a {:href "#"
                      :on-click (partial remove-dice id)}
                  [:span.fa.fa-close " REMOVE"]]]]))

(defn page []
  ;; emtpy start is ugly...
  (if (empty? (get-dices))
    (insert-dice))
  (clear-result)
  (reset-throw-number)
  (fn []
    [:div.main-content
     [:div.content-wrapper
      [:h2.main-title "Choose your dice"]
      (doall (map dice-partial (get-dices)))]
     [:div.footer-actions.c2-col
      [:a.btn.btn-primary {:href "#"
                           :on-click insert-dice} [:span "ADD"]]
      " "
      [:a.btn.btn-secondary {:href "#/roll"} [:span "ROLL"]]]]))
