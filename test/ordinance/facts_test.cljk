(ns ordinance.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest osaka-has-spec-basis
  (let [sb (facts/spec-basis "osaka")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.city.osaka.lg.jp/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "kobe")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["osaka" "kobe"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["kobe"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["osaka.jitensha-chushajo-fuchi-jorei-2010"]
         (mapv :ordinance/id (facts/by-topic "osaka" :transport))))
  (is (empty? (facts/by-topic "osaka" :labor)))
  (is (empty? (facts/by-topic "kobe" :transparency))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/datascript-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
