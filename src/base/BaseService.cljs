(ns gost.base.base-service
  (:use [gost :only (gost)]))

(.factory gost "go_base" (fn [$firebase]
    (js-obj
        "root" #(js/Firebase. "https://go-statistic.firebaseio.com")
        "getCollection" (fn [$scope, col-name]
            ($firebase (js/Firebase.
                (.join (array "https://go-statistic.firebaseio.com/" col-name)
                       ""))
                $scope
                col-name))
        )))
