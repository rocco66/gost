(ns gost.gost-controller)

(.controller (.module js/angular "gost")
             "GostController"
             (fn [$scope]
               (set! (.-tabs $scope)
                     (array
                      (js-obj "title" "first"
                              "content" "content1")
                      (js-obj "title" "second"
                              "content" "content2")))))
