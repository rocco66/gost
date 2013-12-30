(ns gost.add-game-controller
  (:use [gost :only (gost)]))

(defn modalController [$scope $modalInstance  go-base]
    (.getCollection go-base $scope "gamers")
    (.getCollection go-base $scope "games")
    (doto $scope
      (aset "cancel" #(.dismiss $modalInstance "cancel"))
      (aset "add_game" #())
      ))

(.controller gost "AddGameController" (fn [$scope $modal]
  (aset $scope
        "show_add_game_modal" #(.open
            $modal
            (js-obj "templateUrl" "add_game/add_game.html"
                    "controller" modalController)))
  ))
