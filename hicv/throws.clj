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
    [:h2.main-title "Throws"]
    [:ul
     [:li "1"]
     [:li [:div.dice.blue.xsm [:span.number "1"]]]
     [:li [:div.dice.green.xsm [:span.number "3"]]]
     [:li [:div.dice.orange.xsm [:span.number "6"]]]]
    [:ul
     [:li "2"]
     [:li [:div.dice.orange.xsm [:span.number "1"]]]
     [:li [:div.dice.green.xsm [:span.number "3"]]]
     [:li [:div.dice.blue.xsm [:span.number "6"]]]]
    [:ul
     [:li "3"]
     [:li [:div.dice.blue.xsm [:span.number "1"]]]
     [:li [:div.dice.green.xsm [:span.number "3"]]]
     [:li [:div.dice.orange.xsm [:span.number "6"]]]]
    [:div.footer-actions
     [:a.btn.btn-primary {:href "#"} [:span.fa.fa-angle-left] "Back"]
     [:a.btn.btn-secondary {:href "#"} "Clear"]]]]])
