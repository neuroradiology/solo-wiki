(ns solo-wiki.test.handler
  (:use clojure.test
        ring.mock.request  
        solo-wiki.handler))

(deftest test-app
  (testing "redirect home page"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 302))))

  (testing "main route"
    (let [response (app (request :get "/Home"))]
      (is (= (:status response) 200))))
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
