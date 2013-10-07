(ns gost.base.base-service
  (:use [gost :only (gost)]))

(.factory gost "go_base"
    #(js/Firebase. "https://go-statistic.firebaseio.com")
)
