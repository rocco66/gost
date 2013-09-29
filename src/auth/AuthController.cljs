(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope, auth]
    (set! (.-login-twitter $scope) #(.login-twitter auth))
    (set! (.-logout $scope) #(.logout auth))
    (set! (.-is_login $scope) #(.is_login auth))
    ))
