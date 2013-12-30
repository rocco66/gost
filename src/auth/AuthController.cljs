(ns gost.auth.auth-controller
  (:use [gost :only (gost)]))

(.controller gost "AuthController" (fn [$scope go_base]
    (set! (.-logout $scope) (.-logout go_base))
    (set! (.-login $scope) (.-login go_base))
    (.then (.-promise go_base) #(set! (.-user $scope) %))
))
