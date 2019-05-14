Build the jar

`./mvnw clean package`

Build the [Docker](https://www.docker.com/) image

`docker build . -t "kotlin-hello-world"`

Test the [Docker](https://www.docker.com/) image

`docker run -p 8080:8080 kotlin-hello-world:latest`

Create deployment in [minikube](https://kubernetes.io/docs/setup/minikube/)

`minikube start`

`eval $(minikube docker-env)`

`kubectl create -f k8s/deployment-definition.yml`

Create service in [minikube](https://kubernetes.io/docs/setup/minikube/)

`kubectl create -f k8s/service-definition.yml`

Test the service

`curl $(minikube ip):30008/hello`