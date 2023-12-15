#!/bin/bash
(
   helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
   helm install kube-prometheus-stack prometheus-community/kube-prometheus-stack --version 52.1.0 -n monitoring --create-namespace
   helm repo add strimzi https://strimzi.io/charts
)