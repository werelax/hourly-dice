(ns dice.pages.roll
  (:require [dice.state :refer [state]]
            [dice.pages.admin :refer [get-dices]]))

(defn append-to-log [roll]
  (swap! state update-in [:data :log] #(conj % roll)))

(defn save-result [result]
  (swap! state assoc-in [:data :result] result))

(defn clear-result []
  (swap! state assoc-in [:data :result] nil))

(defn get-result []
  (get-in @state [:data :result] nil))

(defn roll-the-dice [dice]
  ;; returns...list of {:color :number}
  (map #(let [color (-> % :color first)
              sides (-> % :sides first)]
          {:color color :number (inc (rand-int sides))})
       dice))

(defn result-item [r]
  [:div.dice-row {:class (:color r)}
   [:div.dice.sm
    [:span.number (:number r)]]])

(defn re-roll
  ([e &r]
   (.preventDefault e)
   (re-roll))
  ([]
   (let [result (roll-the-dice (get-dices))]
     (js/console.log "as")
     (save-result result)
     (append-to-log result))))

(defn page []
  (if (nil? (get-result))
    (re-roll))
  (fn []
    [:div.main-content
     [:h2.main-title "Throw 24"]
     ;; [:div.dice-row.blue [:div.dice.xl [:span.number "5"]]]
     (doall (map result-item (get-result)))
     [:div.footer-actions.3-col
      [:a.btn.btn-primary {:href "#/"} [:span.fa.fa-angle-left] "Back"]
      [:a.btn.btn-secondary {:href "#/roll"
                             :on-click re-roll} "REROLL"]
      [:a.btn.btn-terciary {:href "#/log"} "LOG"]]]))
