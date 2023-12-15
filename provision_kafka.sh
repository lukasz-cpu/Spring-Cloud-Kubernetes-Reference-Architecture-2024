#!/bin/bash
(
   kubectl delete ns kafka
   kubectl create ns kafka
)
(
   helm repo add strimzi https://strimzi.io/charts/
   helm repo update
   helm install strimzi strimzi/strimzi-kafka-operator --namespace kafka
)
(
    cd k8s/kafka
    kubectl apply -f kafka.yaml --namespace kafka
)