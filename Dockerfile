FROM adoptopenjdk/openjdk11:alpine-slim

ENV APPLICATION_USER=app \
    APPLICATION_GROUP=app_group \
    APPLICATION_PATH=/app.jar

RUN addgroup ${APPLICATION_GROUP} && \
    adduser --gecos "" --disabled-password --ingroup ${APPLICATION_GROUP} ${APPLICATION_USER}

RUN apk add --no-cache su-exec

EXPOSE 8990

COPY wrapper.sh /wrapper.sh
RUN chmod 555 /wrapper.sh

ENTRYPOINT ["/wrapper.sh"]

COPY target/kotlin-k8s-hello-world-0.0.1-SNAPSHOT.jar ${APPLICATION_PATH}