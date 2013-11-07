(ns korhal.core
  (:import (jnibwapi JNIBWAPI BWAPIEventListener)
           (jnibwapi.model Unit)
           (jnibwapi.util BWColor)))

(gen-class
 :name "korhal.core"
 :implements [JNIBWAPI]
 :state state
 :main true
 :constructors {[] []}
 :prefix "korhal-")

(defn korhal-main [& args]
  (let [ai (new korhal.core)
        api (JNIBWAPI. ai)]
    (compare-and-set! (.state ai) @(.state ai) (merge @(.state ai) {:api api}))
    (.start api))))

(defn korhal-init [this]
  [[] (atom {})])

(defn korhal-connected [this])

(defn korhal-gameStarted [this]
  (println "Here we go!")
  (doto (:api @(.state this))
    (.enableUserInput)
    (.enablePerfectInformation)
    (.setGameSpeed 0)
    (.loadMapData true)))

(defn korhal-gameUpdate [this])
(defn korhal-gameEnded [this])
(defn korhal-keyPressed [this keycode])
(defn korhal-matchEnded [this winner])
(defn korhal-sendText [this text])
(defn korhal-receiveText [this text])
(defn korhal-nukeDetect [this x y])
(defn korhal-playerLeft [this playerID])
(defn korhal-unitCreate [this unitID])
(defn korhal-unitDestroy [this unitID])
(defn korhal-unitDiscover [this unitID])
(defn korhal-unitEvade [this unitID])
(defn korhal-unitHide [this unitID])
(defn korhal-unitMorph [this unitID])
(defn korhal-unitShow [this unitID])
(defn korhal-unitRenegade [this unitID])
(defn korhal-saveGame [this gameName])
(defn korhal-unitComplete [this unitID])
(defn korhal-playerDropped [this playerID])
