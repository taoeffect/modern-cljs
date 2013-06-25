(defproject modern-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"

  ;; clojure source code path
  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccups "0.2.0"]
                 [domina "1.0.2-SNAPSHOT"]
                 [shoreleave/shoreleave-remote-ring "0.3.0"]
                 [shoreleave/shoreleave-remote "0.3.0"]
                 [com.cemerick/valip "0.3.2"]
                 [enlive "1.1.1"]]

  :plugins [[lein-cljsbuild "0.3.0"]
            [lein-ring "0.8.3"]]

  ;; enable cljsbuild tasks support
  ;; :hooks [leiningen.cljsbuild]

  ;; ring tasks configuration
  :ring {:handler modern-cljs.core/app}

  ;; cljsbuild tasks configuration
  :cljsbuild {:crossovers [valip.core valip.predicates modern-cljs.login.validators]
              :builds
              [{;; build id
                :id "dev"
                :source-paths ["src/brepl" "src/cljs"]

                ;; Google Closure Compiler options
                :compiler {;; the name of emitted JS script file
                           :output-to "resources/public/js/modern_dbg.js"

                           ;; minimum optimization
                           :optimizations :whitespace
                           ;; prettyfying emitted JS
                           :pretty-print true}}
               {;; build id
                :id "pre-prod"
                :source-paths ["src/brepl" "src/cljs"]

                :compiler {;; different JS output name
                           :output-to "resources/public/js/modern_pre.js"

                           ;; simple optimization
                           :optimizations :simple}}
               {;; build id
                :id "prod"
                :source-paths ["src/cljs"]
                :compiler {;; different JS output name
                           :output-to "resources/public/js/modern.js"

                           ;; advanced optimization
                           :optimizations :advanced}}]})
