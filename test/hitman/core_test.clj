(ns hitman.core-test
  (:use clojure.test
        [hitman.core :only [markdown]]))

(deftest empty-input
  (is (= "" (markdown "")))
  (is (= "" (markdown "\n\n\n")))
  (is (= "" (markdown "\r\n\r\n")))
  (is (= "" (markdown "\t\t\t"))))
