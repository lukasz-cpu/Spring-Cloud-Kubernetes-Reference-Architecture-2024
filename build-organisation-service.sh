#!/bin/bash
(
   kubectl delete ns kafka
   kubectl delete namespace monitoring
   kubectl create ns kafka
   kubectl create namespace monitoring
)
(
   kubectl create ns kafka
   kubectl create namespace monitoring
   helm repo add strimzi https://strimzi.io/charts/
   helm repo update
   helm install strimzi strimzi/strimzi-kafka-operator --namespace kafka
)
(
    cd k8s/kafka
    kubectl apply -f kafka.yaml -n kafka
)
(
    k8s/prometheus
    kubectl apply -f prometheus-operator-deployment.yaml -n monitoring - force-conflicts=true - server-side
    kubectl apply -f prometheus.yaml -n monitoring
    kubectl apply -f strimzi-pod-monitor.yaml -n monitoring
    kubectl apply -f grafana.yaml -n monitoring
)
(
   cd emergency-room-service/
   mvn clean package -DskipTests
)
(
   skaffold build
)
(
   skaffold dev
)
