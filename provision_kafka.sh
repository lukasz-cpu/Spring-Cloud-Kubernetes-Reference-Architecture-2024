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
    kubectl apply -f kafka.yaml --namespace kafka
)