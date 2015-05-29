(ns dice.pages.admin
  (:require [dice.state :refer [state]]))

(defonce id (atom 0))

(defn get-dices []
  (get-in @state [:data :dices]))

(defn set-dices [dices]
  (swap! state assoc-in [:data :dices] dices))

(defn make-dice []
  (swap! id inc)
  (let [colors (get-in @state [:config :colors])
        sides (get-in @state [:config :sides])
        id @id]
    {:color (cycle colors) :sides (cycle sides) :id id}))

(defn get-dice [id]
  (first (filter #(= id (:id %)) (get-dices))))

(defn replace-dice [old new]
  (let [id (:id old)]
    (mapv #(if (= (:id %) id) new %) (get-dices))))

(defn without-dice [id]
  (filterv #(not= (:id %) id) (get-dices)))

(defn insert-dice [e]
  (.preventDefault e)
  (set-dices (conj (get-dices) (make-dice))))

(defn remove-dice [id e]
  (.preventDefault e)
  (set-dices (without-dice id)))

(defn rotate-attr [attr id e]
  (.preventDefault e)
  (let [old (get-dice id)
        new (assoc old attr (next (attr old)))]
    (set-dices (replace-dice old new))))

(defn dice-partial [d]
  (let [id (:id d)]
    [:div.dice-row.blue
     [:a.dice {:href "#"
               :on-click (partial rotate-attr :sides id)}
      [:span.number (first (:sides d))]]
     [:a.color {:href "#"
                :on-click (partial rotate-attr :color id)}
      [:span (-> d :color first str)]]
     [:div.close [:a {:href "#"
                      :on-click (partial remove-dice id)}
                  [:span.fa.fa-close]]]]))

(defn page []
  [:div.main-content
   [:h2.main-title "Choose a dice"]
   (doall (map dice-partial (get-dices)))
   [:div.footer-actions
    [:a.btn.btn-primary {:href "#"
                         :on-click insert-dice} "ADD"]
    [:a.btn.btn-secondary {:href "#/roll"} "ROLL"]]])
