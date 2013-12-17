(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope go-base $firebaseAuth]
    ;; (.initialize $firebaseAuth (.root go-base)
    ;;                              (js-obj "scope" $scope "name" "user"))
    (def auth ($firebaseAuth (.root go-base)))
    (defn login-twitter [] (do
                             (def login-promise (.$login auth "twitter"))
                             (.then login-promise #(set! (.-user $scope) %))
                             ))
    (set! (.-login-twitter $scope) login-twitter)
    (set! (.-logout $scope) #(.$logout auth))
    ;; (set! (.-user $scope) #(.$logout auth))
))
