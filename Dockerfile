# Base JDK image : indique l'image parente
# un environnement basé sur un systeme d'exploitation Linux Alpine miniature,
# avec le kit de développement Java 17 d'Eclipse Temurin déjà installé
FROM eclipse-temurin:17-jdk-alpine

# Définit le répertoire de travail à l'intérieur du conteneur
WORKDIR /app

# Copie des fichiers de votre machine locale (code source, fichiers de configuration) vers l'image
COPY target/*.jar app.jar

# Indique le port réseau sur lequel l'application écoute
EXPOSE 8080

#  Spécifie la commande exécutée automatiquement au démarrage du conteneur
# dans notre cas c'est : java -jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]