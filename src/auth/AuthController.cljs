(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope go-base angularFireAuth]
    (.initialize angularFireAuth (.root go-base)
                                 (js-obj "scope" $scope "name" "user"))
    (set! (.-login-twitter $scope) #(.login angularFireAuth "twitter"))
    (set! (.-logout $scope) #(.logout angularFireAuth))
))
