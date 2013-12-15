(ns gost)

(def gost (.module js/angular "gost" (array
                                      "ngRoute"
                                      "ui.bootstrap"
                                      "firebase")))
