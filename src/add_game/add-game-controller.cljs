(ns gost.add-game-controller
  (:use [gost :only (gost)]))

(defn modalController [$scope $modalInstance  go-base]
    (.getCollection go-base $scope "gamers")
    (doto $scope
      (aset "cancel" #(.dismiss $modalInstance "cancel"))
      ))

(.controller gost "AddGameController" (fn [$scope $modal]
  (aset $scope
        "add_game"
        #(.open $modal
                (js-obj "templateUrl" "add_game/add_game.html"
                        "controller" modalController)))
  ))
