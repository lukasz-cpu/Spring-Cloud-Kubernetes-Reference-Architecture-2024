1. kubectl create namespace argocd
2. kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
3. kubectl port-forward svc/argocd-server -n argocd 8080:443
4. argocd admin initial-password -n argocd
5. kubectl create namespace spring-cloud
6. kubectl apply -f spring-cloud-app.yaml