(ns day1.2
  (:require [clojure.string :as str]))

(defn concat-first-and-last-digits [line]
  (let [digits (remove str/blank? (re-seq #"\d" line))]
    (apply str (first digits) (take-last 1 digits))))

(let [input (str/replace (slurp "/mnt/HDD/programming/advent-of-code-2023/day1/input.txt")
                         #"one|two|three|four|five|six|seven|eight|nine"
                         {"one" "1" "two" "2" "three" "3" "four" "4" "five" "5" "six" "6" "seven" "7" "eight" "8" "nine" "9"})]
  (->>
   (str/split-lines input)
   (map concat-first-and-last-digits)
   (map #(Integer/parseInt %))
   (reduce +)))
