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
    [:h2.main-title "Choose a dice"]
    [:div.dice-row.blue
     [:a.dice {:href "#"} [:span.number "5"]]
     [:a.color {:href "#"} [:span "blue"]]
     [:div.close [:a {:href "#"} [:span.fa.fa-close " CLEAR"]]]]
    [:div.dice-row.green
     [:a.dice {:href "#"} [:span.number "5"]]
     [:a.color {:href "#"} [:span "green"]]
     [:div.close [:a {:href "#"} [:span.fa.fa-close " CLEAR"]]]]
    [:div.footer-actions.c2-col
     [:a.btn.btn-primary {:href "#"} [:span "ADD"]]
     [:a.btn.btn-secondary {:href "#"} [:span "ROLL"]]]]]])
