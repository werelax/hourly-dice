(ns dice.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found resources]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [include-js include-css]]
            [prone.middleware :refer [wrap-exceptions]]
            [environ.core :refer [env]]))

(def home-page
  (html
   [:html
    [:head
     [:meta {:charset "utf-8"}]
     [:meta
      {:content "width=device-width, initial-scale=1.0",
       :name "viewport"}]
     [:meta {:content "yes", :name "apple-mobile-web-app-capable"}]
     [:title "Dice"]
     [:link {:href "css/main.css", :rel "stylesheet"}]
     [:link
      {:href "css/font-awesome.min.css", :rel "stylesheet"}]
     [:link
      {:type "text/css",
       :rel "stylesheet",
       :href "http://fonts.googleapis.com/css?family=Lato:300,400,700"}]]
    [:body
     [:div#app]
     (include-js "js/app.js")]]))

(defroutes routes
  (GET "/" [] home-page)
  (resources "/")
  (not-found "Not Found"))

(def app
  (let [handler (wrap-defaults routes site-defaults)]
    (if (env :dev) (wrap-exceptions handler) handler)))
