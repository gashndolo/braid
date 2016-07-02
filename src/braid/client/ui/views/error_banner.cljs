(ns braid.client.ui.views.error-banner
  (:require [braid.client.reagent-adapter :refer [subscribe]]
            [braid.client.store :as store]))

(defn error-banner-view []
  (let [errors (subscribe [:errors])]
    (fn []
      [:div.error-banners
       (doall
         (for [[err-key err cls] @errors]
           ^{:key err-key}
           [:div.error-banner
            {:class cls}
            err
            [:span.close
             {:on-click (fn [_] (store/clear-error! err-key))}
             "×"]]))])))
