(ns remote-eval.rpc
  (:require-macros
    [tailrecursion.javelin :refer [defc defc=]])
  (:require
   [tailrecursion.javelin]
   [tailrecursion.castra :refer [mkremote]]))

(defc state {:result nil})
(defc error nil)
(defc loading [])
(defc input-code nil)

(defc= evaluated-code (get state :result))

(def set-code! #(reset! state {:result %}))

(def eval-code
  (mkremote 'remote-eval.api/eval-code state error loading))

(def get-state
  (mkremote 'remote-eval.api/eval-code state error loading))

(defn init []
  (get-state)
  ;; (js/setInterval get-state 1000)
  )
