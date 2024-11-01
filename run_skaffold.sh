#!/bin/bash

# Przejście do katalogu emergency-room-service
cd emergency-room-service/ || { echo "Nie udało się przejść do katalogu emergency-room-service"; exit 1; }

# Budowanie projektu za pomocą Maven, pomijając testy
mvn clean package -DskipTests || { echo "Budowanie Maven nie powiodło się"; exit 1; }

# Powrót do pierwotnego katalogu
cd - || { echo "Nie udało się wrócić do pierwotnego katalogu"; exit 1; }

cd config-server/ || { echo "Nie udało się przejść do katalogu emergency-room-service"; exit 1; }

mvn clean package -DskipTests || { echo "Budowanie Maven nie powiodło się"; exit 1; }

cd - || { echo "Nie udało się wrócić do pierwotnego katalogu"; exit 1; }

# Budowanie projektu za pomocą Skaffold
skaffold build || { echo "Budowanie Skaffold nie powiodło się"; exit 1; }

