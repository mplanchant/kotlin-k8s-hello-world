FROM openjdk:11-jre-slim

ENV APPLICATION_USER=app \
    APPLICATION_GROUP=app_group \
    APPLICATION_PATH=/app.jar

RUN addgroup ${APPLICATION_GROUP} && \
    adduser --gecos "" --disabled-password --ingroup ${APPLICATION_GROUP} ${APPLICATION_USER}

RUN apt-get update && apt-get install -y --no-install-recommends \
    gosu \
    && rm -rf /var/lib/apt/lists/*

EXPOSE 8990

COPY wrapper.sh /wrapper.sh
RUN chmod 555 /wrapper.sh

ENTRYPOINT ["/wrapper.sh"]

COPY target/kotlin-k8s-hello-world-0.0.1-SNAPSHOT.jar ${APPLICATION_PATH}
