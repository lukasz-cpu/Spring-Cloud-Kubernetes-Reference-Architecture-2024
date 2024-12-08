kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
kubectl port-forward svc/argocd-server -n argocd 8080:443
argocd admin initial-password -n argocd
kubectl create namespace spring-cloud
kubectl apply -f spring-cloud-app.yaml

-----------------------------------

Instalacja ingress'a

https://kubernetes.github.io/ingress-nginx/deploy/#docker-for-mac

working after this tut

-----------------------------------
