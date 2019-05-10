#!/usr/bin/env bash

set -eo pipefail

# Enables application to take PID 1 and receive SIGTERM sent by Docker stop command.
exec gosu ${APPLICATION_USER} java \
    -Djava.security.egd=file:/dev/./urandom \
    ${APPLICATION_JAVA_OPTS} -jar ${APPLICATION_PATH} ${APPLICATION_OPTS}
