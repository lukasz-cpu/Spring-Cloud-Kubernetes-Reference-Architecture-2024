#!/bin/bash

kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
kubectl port-forward svc/argocd-server -n argocd 8080:443 &
ARGOCD_PASSWORD=$(argocd admin initial-password -n argocd)
echo "Hasło administracyjne ArgoCD: $ARGOCD_PASSWORD"
kubectl create namespace spring-cloud
kubectl apply -f spring-cloud-app.yaml -n spring-cloud
