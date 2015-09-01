(ns remote-eval.api
  (:require [tailrecursion.castra :refer [defrpc]]))

(def integers (iterate inc 0))

(defn average [lst] (/ (reduce + lst) (count lst)))
(defn moving-average [window lst] (map average (partition window 1 lst)))

(defrpc eval-code [& [code]]
  (let [result (and code (eval (read-string code)))]
    (println (str "(eval " (or code "nil") ") => " (or result) "nil"))
    {:result result}))

;; examples (run in the "web repl"):
;; (take 10 (remote-eval.api/moving-average 5 remote-eval.api/integers))
;; (remote.eval.api/average '(1 2 3))
