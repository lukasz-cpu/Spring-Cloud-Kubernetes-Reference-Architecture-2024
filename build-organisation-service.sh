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
(
    cd k8s/prometheus
    kubectl apply -f prometheus-operator-deployment.yaml --namespace monitoring --force-conflicts=true --server-side
    kubectl apply -f prometheus.yaml --namespace monitoring
    kubectl apply -f strimzi-pod-monitor.yaml --namespace monitoring
    kubectl apply -f grafana.yaml --namespace monitoring
)
