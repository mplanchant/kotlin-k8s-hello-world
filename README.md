# kotlin-k8s-hello-world

[![Build Status](https://travis-ci.com/mplanchant/kotlin-k8s-hello-world.svg?branch=master)](https://travis-ci.com/mplanchant/kotlin-k8s-hello-world)

## Requirements

* [Java 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot) 
* [Docker](https://www.docker.com/)
* [Minikube](https://kubernetes.io/docs/tasks/tools/install-minikube/)

## Running the application locally with Kubernetes via Minikube

Compile and build the Docker image

`./mvnw compile jib:dockerBuild`

Test the Docker image

`docker run -p 8080:8080 kotlin-k8s-hello-world:0.0.1-SNAPSHOT`

`curl localhost:8080/hello`

Create deployment in Minikube

`minikube start`

`eval $(minikube docker-env)`

`kubectl create -f k8s/deployment-definition.yml`

Create service in Minikube

`kubectl create -f k8s/service-definition.yml`

Test the service

`curl $(minikube ip):30008/hello`
