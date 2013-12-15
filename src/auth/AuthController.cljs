(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope go-base $firebaseAuth]
    (.initialize $firebaseAuth (.root go-base)
                                 (js-obj "scope" $scope "name" "user"))
    (set! (.-login-twitter $scope) #(.login $firebaseAuth "twitter"))
    (set! (.-logout $scope) #(.logout $firebaseAuth))
))
