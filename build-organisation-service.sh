#!/bin/bash
(
   cd organisation-service/
   mvn clean package -DskipTests
)
(
   skaffold build
)
(
   skaffold dev
)