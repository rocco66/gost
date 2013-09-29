(ns gost.auth.auth-service
  (:use [gost :only (gost)]))

(def chatRef (js/Firebase. "https://go-statistic.firebaseio.com"))
(def auth (js/FirebaseSimpleLogin. chatRef, (fn [error, user]
    (if error
        (.log js/console error)
        (if user (.log js/console user))))))

(.factory gost "auth" (fn [] (js-obj
    "login_twitter" #(.login auth "twitter")
    "logout" #(.logout auth)
    "is_login" #(not (nil? (.id auth)))
    )))
