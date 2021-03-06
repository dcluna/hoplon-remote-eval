#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.5.1"

(set-env!
  :project      'remote-eval
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.2.4"]
                  ;; [tailrecursion/hoplon      "6.0.0-alpha7"]
                  [tailrecursion/hoplon      "5.10.25"]
                  ]
  :out-path     "resources/public"
  :src-paths    #{"src/hl" "src/cljs" "src/clj"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require '[tailrecursion.hoplon.boot :refer :all]
         '[tailrecursion.castra.task :as c]
         )

(deftask development
  "Build remote-eval for development."
  []
  (comp (watch) (hoplon {:prerender false}) (c/castra-dev-server 'remote-eval.api)))

(deftask dev-debug
  "Build remote-eval for development with source maps."
  []
  (comp (watch) (hoplon {:pretty-print true
                         :prerender false
                         :source-map true}) (c/castra-dev-server 'remote-eval.api)))

(deftask production
  "Build remote-eval for production."
  []
  (hoplon {:optimizations :advanced}))
