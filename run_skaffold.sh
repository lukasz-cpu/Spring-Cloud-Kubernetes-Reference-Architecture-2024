#!/bin/bash
(
   cd emergency-room-service/
   mvn clean package -DskipTests


   skaffold build

(
   skaffold dev
)