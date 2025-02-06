# Bank Account Kata

## Description
Ce projet est une implémentation d'un kata bancaire en Java, permettant de gérer un compte bancaire avec les opérations suivantes :
- Dépôt d'argent
- Retrait d'argent
- Consultation de l'historique des transactions

## Prérequis
- Java 11 ou supérieur
- Maven 3+

## Installation
1. Cloner le dépôt :
   ```sh
   git clone git@github.com:MohamedMakdoudi/BankAccountkata.git
   cd BankAccountkata
   ```
2. Compiler et installer les dépendances avec Maven :
   ```sh
   mvn clean install
   ```

## Exécution
1. Lancer l'application :
   ```sh
   mvn exec:java -Dexec.mainClass="com.sg.Main"
   ```

## Tests
Les tests unitaires sont définis dans `src/test/java/com/sg/test`. Pour les exécuter :
   ```sh
   mvn test
   ```

## Structure du projet
```
BankAccountkata/
├── pom.xml  # Fichier de configuration Maven
├── src/
    ├── main/java/com/sg/  # Code source principal
    ├── test/java/com/sg/test/  # Tests unitaires
```

## Intégration Continue
Un fichier `java-ci.yml` est présent pour l'intégration continue via GitHub Actions.

## Auteur
Développé par BEN MOKDAD Mohamed

