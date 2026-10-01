# AutoLoc API

Projet Spring Boot + Maven basé sur l'Atelier 1 — ASI 26-27.

## Stack
- Java 17
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Validation
- Spring Boot DevTools

## Lancement

1. Ouvrir le projet `autoloc-api` dans IntelliJ IDEA.
2. Vérifier que Java 17 est configuré.
3. Vérifier que MySQL est démarré.
4. Mettre le mot de passe MySQL dans la variable d'environnement `DB_PASSWORD`,
   ou adapter `spring.datasource.password` dans `application.properties`.
5. Lancer `AutolocApiApplication`.
6. Hibernate doit créer/mettre à jour les tables dans `autoloc_db`.

## Entités de l'Atelier 1

- Vehicule
- Agence
- Client
- Employe
- Equipement
- Reservation
- Contrat
- Paiement
- Maintenance

Aucune association n'est volontairement présente : les associations sont prévues
pour l'Atelier 2.

## Remarque sur les types

Le support donne les noms des attributs mais pas toujours leurs types ni toutes
les contraintes SQL pour les huit entités supplémentaires. Les choix utilisés ici
sont des choix raisonnables pour obtenir un projet compilable :
- dates -> `LocalDate`
- montants -> `BigDecimal`
- `valide` -> `Boolean`
- textes -> `String`

Les contraintes précises peuvent être ajustées si l'enseignant fournit un modèle
de données plus détaillé.
