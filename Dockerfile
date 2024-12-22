# Utiliser l'image officielle de Keycloak
FROM quay.io/keycloak/keycloak:latest

# Définir les variables d'environnement pour la configuration de Keycloak
ENV KEYCLOAK_USER=admin
ENV KEYCLOAK_PASSWORD=admin
ENV KC_BOOTSTRAP_ADMIN_USERNAME=admin
ENV KC_BOOTSTRAP_ADMIN_PASSWORD=admin

# Activer les logs en mode DEBUG
ENV KC_LOG_LEVEL=DEBUG

# Exposer le port 8080 pour Keycloak
EXPOSE 8080

# Démarrer Keycloak en mode développement avec un niveau de log DEBUG
CMD ["start-dev", "--log-level", "DEBUG"]
