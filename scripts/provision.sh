#!/bin/bash
(
   helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
   helm repo update
   helm install kube-prometheus-stack prometheus-community/kube-prometheus-stack --version 52.1.0 -n monitoring --create-namespace
   helm repo add strimzi https://strimzi.io/charts
   helm install strimzi-kafka-operator strimzi/strimzi-kafka-operator --version 0.38.0 -n strimzi --create-namespace -f strimzi-values.yaml
   kubectl apply -f kafka-metrics.yaml
   kubectl apply -f kafka-deployment.yaml
)