([:html
  [:head
   [:meta {:charset "utf-8"}]
   [:meta
    {:content "width=device-width, initial-scale=1.0",
     :name "viewport"}]
   [:meta {:content "yes", :name "apple-mobile-web-app-capable"}]
   [:title "Dice"]
   [:link {:href "/assets/css/main.css", :rel "stylesheet"}]
   [:link
    {:href "/assets/css/font-awesome.min.css", :rel "stylesheet"}]
   [:link
    {:type "text/css",
     :rel "stylesheet",
     :href "http://fonts.googleapis.com/css?family=Lato:300,400,700"}]
   [:script {:src "assets/javascripts/lib/jquery-1.9.1.min.js"}]
   [:script {:src "assets/javascripts/script.js"}]]
  [:body
   [:div.main-content
    [:h2.main-title "Throw 24"]
    [:div.dice-row.blue [:div.dice.xl [:span.number "5"]]]
    [:div.dice-row
     [:div.dice.m.green [:span.number "2"]]
     [:div.dice.m.orange [:span.number "2"]]]
    [:div.dice-row
     [:div.dice.sm.green [:span.number "6"]]
     [:div.dice.sm.orange [:span.number "3"]]
     [:div.dice.sm.blue [:span.number "3"]]]
    [:div.footer-actions.c3-col
     [:a.btn.btn-primary {:href "#"} [:span "Back"]]
     [:a.btn.btn-secondary {:href "#"} [:span "REROLL"]]
     [:a.btn.btn-terciary {:href "#"} [:span "LOG"]]]]]])
