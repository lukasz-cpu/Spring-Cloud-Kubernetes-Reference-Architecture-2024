1. kubectl create ns kafka
2. kubectl create -f 'https://strimzi.io/install/latest?namespace=kafka' -n kafka
3. helm repo update
4. helm install strimzi strimzi/strimzi-kafka-operator --namespace kafka
5. kubectl create namespace monitoring