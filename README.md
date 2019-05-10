Build the jar

`./mvnw clean package`

Build the [Docker](https://www.docker.com/) image

`docker build . -t "kotlin-hello-world"`

Test the [Docker](https://www.docker.com/) image

`docker run -p 8080:8080 kotlin-hello-world:latest`

Create deployment in [minikube](https://kubernetes.io/docs/setup/minikube/)

`eval $(minikube docker-env)`

`kubectl create -f deployment-definition.yml`

Create service in [minikube](https://kubernetes.io/docs/setup/minikube/)

`kubectl create -f service-definition.yml`

Test the service

`curl $(minikube ip):30008/hello`

