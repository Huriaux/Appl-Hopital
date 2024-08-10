# Règles de gestion

## Acteurs
- **Secrétaire médical** : Seule avec accès complet à toutes les fonctionnalités.

## Conditions
- L'hôpital est divisé en quatre services : Service-1, Service-2, Service-3, et Urgences.
- Chaque service contient 10 chambres.
- Chaque chambre dispose d'un seul lit.
- Un patient doit être enregistré dans la base de données avant de pouvoir être affecté à un lit dans un service.
- À l'enregistrement de la sortie d'un patient, le lit est automatiquement libéré.


## Actions et Règles

- La **Secrétaire médical** doit pouvoir ajouter un nouveau patient.

- La **Secrétaire médical** doit pouvoir rechercher un patient existant.
    - Si le patient existe, la **Secrétaire médical** doit pouvoir modifier les informations du patient existant.

- La **Secrétaire médical** doit pouvoir prendre en compte l’arrivée d’un patient dans un service.
    - La **Secrétaire médical** doit pouvoir créer un séjour pour un patient.
        - Ici également, la **Secrétaire médical** doit pouvoir rechercher un patient existant.
        - Si le patient existe, la **Secrétaire médical** doit pouvoir ajouter le patient existant au séjour.

- Une fois la création du séjour établit, la **Secrétaire médical** doit pouvoir affecter un lit disponible au patient en séjour.

- La **Secrétaire médical** doit pouvoir également prendre en compte la sortie d’un patient.


---
<!-- Bouton 'Retour vers le Sommaire' et Bouton 'Retour vers haut' du document -->
<div align="right">
    <a href="#règles-de-gestion">
        <img src="../img/image-docs/icon-vers-le-haut.png" alt="Retour vers le haut" style="width: 25px;" />
    </a>
</div>
<div align="left">
    <a href="/README.md">
        <img src="../img/image-docs/summary.png" alt="Retour vers le haut" style="width: 100px;" />
    </a>
</div>