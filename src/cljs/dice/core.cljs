(ns dice.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [goog.events :as events]
              [goog.history.EventType :as EventType]
              ;; dice
              [dice.state :refer [state]]
              [dice.pages.admin :as admin]
              [dice.pages.roll :as roll]
              [dice.pages.log :as log])
    (:import goog.History))

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute "/" []
  (session/put! :current-page #'admin/page))

(secretary/defroute "/roll" []
  (session/put! :current-page #'roll/page))

(secretary/defroute "/log" []
  (session/put! :current-page #'log/page))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Root view

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (hook-browser-navigation!)
  (mount-root))
