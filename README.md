# Projet : Intégration de Keycloak et Sécurisation d'une Application Spring Boot

## Contexte du projet

Cette phase du projet vise à renforcer la sécurité de l'application en intégrant un fournisseur d'identité tiers (Keycloak) pour l'authentification et l'autorisation, ainsi qu'en activant HTTPS avec SSL/TLS. En parallèle, des pratiques CI/CD sont mises en place pour automatiser le déploiement et les tests.

---

## Objectifs

### Sécurité
- **Authentification et autorisation** :
  - Intégrer **Keycloak** pour gérer les mécanismes d'authentification et d'autorisation.
  - Configurer les rôles et permissions dans Keycloak.
  - Activer HTTPS avec un certificat SSL/TLS pour chiffrer les communications.
  - Implémenter **OAuth 2.0** pour sécuriser les endpoints REST.
  - Restreindre l'accès aux fonctionnalités en fonction des rôles avec **Spring Security** et le fournisseur d'identité.
  - Protéger les endpoints REST via des filtres de sécurité et des tokens OAuth 2.0 valides.
  - Configurer la validation **CORS** pour limiter les origines approuvées.

### Déploiement
- **Automatisation CI/CD avec Jenkins** :
  - Configurer un serveur **Jenkins** pour automatiser le processus CI/CD.
  - Créer un pipeline capable de :
    1. Récupérer le code source depuis un dépôt Git.
    2. Compiler et construire le projet.
    3. Lancer les tests unitaires et générer des rapports de couverture.
    4. Déployer l'application dans un conteneur Docker après validation.
    5. Configurer des notifications pour informer les développeurs des résultats des builds et tests.
  - Documenter le processus CI/CD et les configurations mises en place.

---

## Configuration de l'application Spring Boot

### HTTPS avec SSL/TLS
Configurer le serveur pour écouter sur le port HTTPS en modifiant les fichiers de configuration Spring Boot :
- `application.properties` ou `application.yml` :
  ```properties
  server.port=8443
  server.ssl.key-store=classpath:keystore.p12
  server.ssl.key-store-password=yourPassword
  server.ssl.key-store-type=PKCS12
  server.ssl.key-alias=yourAlias
