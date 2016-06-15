(def project 'boot-files)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"src"}
          :source-paths #{"test"}
          :asset-paths #{"resources"}
          :dependencies '[[adzerk/boot-test "1.1.1" :scope "test"]
                          [adzerk/boot-cljs "1.7.228-1" :scope "test"]
                          [adzerk/boot-cljs-repl "0.3.0" :scope "test"]
                          [com.cemerick/piggieback "0.2.1" :scope "test"]
                          [weasel "0.7.0" :scope "test"]
                          [org.clojure/tools.nrepl "0.2.12" :scope "test"]
                          [adzerk/boot-reload "0.4.8" :scope "test"]
                          [pandeiro/boot-http "0.7.3" :scope "test"]
                          [cljsjs/boot-cljsjs "0.5.1" :scope "test"]
                          [org.clojure/clojure "1.8.0"]
                          [org.clojure/clojurescript "1.9.36"]
                          [rum "0.9.0"]])

(require
  '[adzerk.boot-cljs :refer :all]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
  '[adzerk.boot-reload :refer [reload]]
  '[pandeiro.boot-http :refer :all]
  '[cljsjs.boot-cljsjs :refer :all])

(task-options!
  pom {:project     project
       :version     version
       :description "FIXME: write description"
       :url         "http://example/FIXME"
       :scm         {:url "https://github.com/yourname/boot-files"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}}
  reload {:on-jsload 'boot-files.core/main})

(deftask web-dev
         []
         (comp
           (serve :dir "target")
           (watch)
           (cljs-repl)
           (speak)
           (reload)
           (cljs)
           (target)))