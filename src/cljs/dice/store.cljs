(ns dice.store
  (:require [dice.state :refer [state]]))

;; -------------------------
;; Initial data
(reset! state {:data {:dices [] :log [] :result nil :throws 0}
               :config {:colors ["green" "blue" "orange" "pink" "yellow"]
                        :sides [6 8 12 20 4]}})

(defonce id (atom 0))

;;-------------------------
;; Domain functions
(declare get-throw-number)

;; Admin

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

(defn insert-dice
  ([e &r] (.preventDefault e) (insert-dice))
  ([] (set-dices (conj (get-dices) (make-dice)))))

(defn remove-dice [id e]
  (.preventDefault e)
  (set-dices (without-dice id)))

(defn rotate-attr [attr id e]
  (.preventDefault e)
  (let [old (get-dice id)
        new (assoc old attr (next (attr old)))]
    (set-dices (replace-dice old new))))

;; Log

(defn get-log []
  (reverse (get-in @state [:data :log] [])))

(defn clear-log []
  (swap! state assoc-in [:data :log] []))

(defn append-to-log [roll]
  (when (not-empty roll)
    (let [log (get-in @state [:data :log] [])
          info {:throw (get-throw-number) :roll roll}
          newlog (conj log info)]
      (swap! state assoc-in [:data :log]
             (into [] (take-last 10 newlog)))))) ;; 10 rolls in the log

;; Roll

(defn save-result [result]
  (swap! state assoc-in [:data :result] result))

(defn clear-result []
  (swap! state assoc-in [:data :result] nil))

(defn get-result []
  (get-in @state [:data :result] nil))

(defn get-throw-number []
  (get-in @state [:data :throws] 0))

(defn inc-throw-number []
  (swap! state update-in [:data :throws] inc))

(defn reset-throw-number []
  (swap! state assoc-in [:data :throws] 0))

(defn roll-the-dice [dice]
  ;; returns...list of {:color :number}
  (map #(let [color (-> % :color first)
              sides (-> % :sides first)]
          {:color color :number (inc (rand-int sides))})
       dice))

(defn re-roll
  ([e &r]
   (.preventDefault e)
   (re-roll))
  ([]
   (let [result (roll-the-dice (get-dices))]
     (inc-throw-number)
     (save-result result)
     (append-to-log result))))
