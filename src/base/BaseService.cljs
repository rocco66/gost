(ns gost.base.base-service
  (:use [gost :only (gost)]))

(.service gost "go_base" (fn [$firebase $rootScope $q $firebaseAuth]
  (do
    (def root-url "https://go-statistic.firebaseio.com")
    (def root-ref (js/Firebase. root-url))
    (def auth ($firebaseAuth root-ref))
    (def deferred (.defer $q))
    (defn login [] (.$login auth "twitter"))
    (defn logout [] (.$logout auth))
    (defn get-collection [scope col-name]
      (.then (.-promise deferred)
             #(.$bind ($firebase (js/Firebase. (str root-ref "/" col-name)))
                      scope
                      col-name)))
    (.$on $rootScope "$firebaseAuth:login" #(.resolve deferred (.-user auth)))
    (js-obj "auth" auth
            "login" login
            "logout" logout
            "promise" (.-promise deferred)
            "getCollection" get-collection
            ))))
