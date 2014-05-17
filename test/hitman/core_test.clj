(ns hitman.core-test
  (:use clojure.test
        [hitman.core :only [markdown]]))

(deftest empty-input
  (is (= "" (markdown "")))
  (is (= "" (markdown "\n\n\n")))
  (is (= "" (markdown "\r\n\r\n")))
  (is (= "" (markdown "\t\t\t"))))

(deftest basic-input
  (is (= "<p>a</p>" (markdown "a")))
  (is (= "<p>a</p><p>b</p>" (markdown "a\nb")))
  (is (= "<p>a</p><p>b</p>" (markdown "a\n\nb"))))

(deftest basic-emphasis
  (is (= "<p><em>a</em></p>" (markdown "*a*")))
  (is (= "<p><em>a</em></p>" (markdown "_a_")))
  (is (= "<p><strong>a</strong></p>" (markdown "__a__")))
  (is (= "<p><strong>a</strong></p>" (markdown "**a**"))))

(deftest inline-emphasis
  (is (= "<p>a<em>b</em>c</p>" (markdown "a*b*c"))))
