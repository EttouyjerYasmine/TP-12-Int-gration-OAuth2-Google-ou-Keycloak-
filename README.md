# TP 12 – Intégration OAuth2 avec Google (Spring Boot)

## 🎯 Objectif du TP
Ce TP consiste à intégrer l’authentification OAuth2 via Google dans une application Spring Boot.  
L’utilisateur pourra se connecter en utilisant son compte Google, et Spring Security gèrera automatiquement le processus OAuth2.

---

## 🛠️ Technologies utilisées
- Spring Boot 3+
- Spring Security 6
- Spring Web
- Spring OAuth2 Client
- Maven
- Java 17+
- Google Cloud Console (OAuth2)

---

## 📁 Structure du projet
```
src/main/java/...     → Code Java
src/main/resources/   → application.yml, application-local.yml, templates
```

---

## ⚙️ Configuration Google OAuth2

### 1️⃣ Créer un projet Google Cloud
1. Aller sur : https://console.cloud.google.com
2. Créer un projet ou sélectionner un existant
3. Activer **Google OAuth2**

### 2️⃣ Générer un Client OAuth2
- Menu → **APIs & Services** → **Credentials**
- Cliquer **Create Credentials**
- Choisir : **OAuth client ID**
- Type : **Web Application**
- Ajouter l’URL de redirection :
```
http://localhost:8080/login/oauth2/code/google
```
- Copier :
  - **Client ID**
  - **Client Secret**

---

## 🔧 Configuration Spring Boot

Créer `src/main/resources/application-local.yml` :

```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: VOTRE_CLIENT_ID
            client-secret: VOTRE_SECRET
            scope:
              - openid
              - profile
              - email
        provider:
          google:
            issuer-uri: https://accounts.google.com
server:
  port: 8080
```

⚠️ **Ne jamais mettre ces informations dans GitHub !**

---

## 🗂️ Fichier `.gitignore`
Assurez-vous que le fichier `.gitignore` contient :

```
src/main/resources/application-local.yml
```

Cela évite de pousser votre secret sur GitHub.

---

## ▶️ Lancement de l’application

Utiliser le profil `local` :

```
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

Puis ouvrir :

```
http://localhost:8080
```

---

## 🔐 Fonctionnement

1. L’utilisateur clique sur **Login with Google**
2. Il est redirigé vers Google pour autorisation
3. Google renvoie un token à l'application
4. Spring Security authentifie l’utilisateur automatiquement

---

## ✔️ Résultat attendu
Après connexion, vous devez voir les informations de l’utilisateur authentifié.

Exemple :
- Nom
- Email
- Photo
- ID Google

---

## 🧹 Sécurité – Points importants
- **Ne pousse jamais ton Client Secret dans GitHub**
- Utilise un fichier ignoré (`application-local.yml`)
- Utilise des variables d’environnement si nécessaire

---

## 📚 Liens utiles
- Documentation Spring Security : https://docs.spring.io
- OAuth2 Google : https://developers.google.com/identity/protocols/oauth2
- Error 401 invalid_client → Mauvaise configuration du Client ID ou Secret

  
## 📚 Test

-![-](https://github.com/user-attachments/assets/ea45d53d-bed3-42ec-947c-42b5b3795e0c)
-![2](https://github.com/user-attachments/assets/45e8bd95-4c29-4064-8708-bbba8536be5b)
