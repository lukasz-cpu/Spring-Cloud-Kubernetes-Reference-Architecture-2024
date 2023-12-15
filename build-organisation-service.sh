#!/bin/bash
(
  kubectl delete namespace kafka
  kubectl delete namespace spring-cloud-app
)
(
   cd emergency-room-service/
   mvn clean package -DskipTests
)
(
   skaffold build
)
(
   kubectl create namespace kafka
   kubectl create namespace spring-cloud-app
)
(
   skaffold dev
)
