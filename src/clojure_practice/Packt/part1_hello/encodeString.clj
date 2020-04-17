(ns clojure-practice.Packt.part1-hello.encodeString)

(defn encode-letter [s x]
  (let [code (Math/pow (+ x (int (first (char-array s)))) 2)]
    (str "#" (int code))))

(defn encode [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"\w" (fn [s] (encode-letter s number-of-words)))))

(println (encode "test msg"))

(defn decode-letter [x y]
  (let [number (Integer/parseInt (subs x 1))
        letter (char (- (Math/sqrt number) y))]
    (str letter)))

(defn decode [s]
  (let [number-of-words (count (clojure.string/split s #" "))]
    (clojure.string/replace s #"#\d+" (fn [s] (decode-letter s number-of-words)))))

(println (decode (encode "test msg")))