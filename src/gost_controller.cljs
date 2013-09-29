(ns gost.gost-controller)

;; (.controller (.module js/angular "gost")
;;     "GostController"
;;     (fn [$scope]
;;      (def chatRef (js/Firebase. "https://go-statistic.firebaseio.com"))
;;      (def auth (js/FirebaseSimpleLogin. chatRef,
;;          (fn [error, user]
;;            (if error
;;                (.log js/console error)
;;                (if user(set! (.-user $scope) user))))))
;;      (set! (.-login-twitter $scope)
;;            (fn [] (.login auth "twitter")))))
