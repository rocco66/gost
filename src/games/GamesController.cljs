(ns gost.games.games-controller
  (:use [gost :only (gost)]))

(.controller gost "GamesController" (fn [$scope go-base]
(.getCollection go-base $scope "games")
    ))
