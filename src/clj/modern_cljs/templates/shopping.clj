(ns modern-cljs.templates.shopping
  (:require [net.cgrand.enlive-html :refer [deftemplate set-attr]]))

(deftemplate shopping "public/shopping.html"
  [quantity price tax discount] nil nil)
