(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest osaka-has-culture-basis
  (let [sb (facts/spec-basis "osaka")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "osaka" (:culture/municipality %)) sb))
    (is (every? #(= "JPN" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "kobe")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["osaka" "kobe"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["kobe"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "osaka" :dish))))
  (is (= ["osaka.festival.tenjin-matsuri"]
         (mapv :culture/id (facts/by-kind "osaka" :festival))))
  (is (empty? (facts/by-kind "osaka" :craft)))
  (is (empty? (facts/by-kind "kobe" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
