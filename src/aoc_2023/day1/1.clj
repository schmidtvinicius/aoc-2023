(ns day1.1
  (:require [clojure.string :as str]))

(defn concat-first-and-last-digits [line]
  (let [digits (remove str/blank? (re-seq #"\d" line))]
    (apply str (first digits) (take-last 1 digits))))

(let [input (slurp "resources/day1/input.txt")]
  (reduce +
          (map #(Integer/parseInt %) (map concat-first-and-last-digits (str/split-lines input)))))
