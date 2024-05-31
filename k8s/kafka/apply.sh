#!/bin/bash
kubectl apply -f kafka.yaml
kubectl apply -f namespace.yaml
kubectl apply -f zookeeper.yaml