(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope, angularFireAuth]
    (def ref (js/Firebase. "https://go-statistic.firebaseio.com"))
    (.initialize angularFireAuth ref (js-obj "scope" $scope "name" "user"))
    (set! (.-login-twitter $scope) #(.login angularFireAuth "twitter"))
    (set! (.-logout $scope) #(.logout angularFireAuth))
))
