(ns gost.dashboard.dashboard-controller
  (:use [gost :only (gost)]))

(.controller gost "DashboardController" (fn [$scope go-base]
   (.getCollection go-base $scope "messages")
    ))
