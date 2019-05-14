## Requirements

* [Java 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot) 
* [Docker](https://www.docker.com/)
* [Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

## Running the application locally with Kubernetes via Minikube

Build the jar

`./mvnw clean package`

Build the Docker image

`docker build . -t "kotlin-hello-world"`

Test the Docker image

`docker run -p 8080:8080 kotlin-hello-world:latest`

Create deployment in Minikube

`minikube start`

`eval $(minikube docker-env)`

`kubectl create -f k8s/deployment-definition.yml`

Create service in Minikube

`kubectl create -f k8s/service-definition.yml`

Test the service

`curl $(minikube ip):30008/hello`