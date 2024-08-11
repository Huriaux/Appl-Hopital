# Documentation du MERISE (DP)

**Merise** est une méthode de modélisation utilisée pour concevoir et structurer les données et les processus d'un système d'information. Elle permet de représenter de manière claire et détaillée les besoins fonctionnels et les interactions au sein d'un système, en offrant une vue d'ensemble structurée qui facilite la compréhension, la conception et la mise en œuvre de la base de données. 

Dans le cadre de ce projet de gestion des patients pour un hôpital, l'objectif principal de la méthode Merise est de concevoir une base de données efficace et adaptée aux besoins spécifiques de l'application. Grâce à Merise, nous pouvons structurer les données relatives aux patients, aux séjours et aux autres éléments essentiels du système. 

Le système a pour objectif de gérer les patients hospitalisés depuis leur admission jusqu'à leur sortie: Les entités principales comprennent l'administrateur, les patients, les séjours, les services, les lits et les chambres.

Les règles métier incluent la gestion des admissions et des sorties, ainsi que l'affectation des patients aux services et aux lits, et la libération de la chambre (donc du lit) à la sortie d'un patient.

Les fonctionnalités principales sont la gestion des patients (ajout et modification), la gestion des séjours (arrivée et sortie) et l'affectation des patients aux services et aux lits.

Chaque entité est caractérisée par des attributs spécifiques, tels que l'identifiant, le nom, la date, etc qui définissent leurs propriétés et relations

**<u>Ainsi, Merise se compose de quatre parties principales que j’ai appliquer dans le cadre du projet :</u>**


- Le **Modèle Conceptuel de Données (MCD)** est un schéma abstrait qui représente les entités et leurs relations pour comprendre la structure de données.  Ici le MCD permet de visualiser les entités principales telles que `Patient`, `Séjour` etc.  ainsi que les relations entre elles, comme les admissions par exemple.
 
- Le **Modèle Logique de Données (MLD)** qui est la transition du MCD vers un modèle adapté à l’implémentation dans une BDD, pour rendre une représentation plus précise de la BDD. Pour l'application de gestion des patients, le MLD transforme les entités et relations du MCD en tables et clés, définissant clairement les attributs et les relations entre ces tables pour une implémentation efficace dans une base de données relationnelle.

- Le **Dictionnaire de Données** est un document centralisé qui décrit en détail chaque élément de données d'un système d'information afin d'assurer une compréhension et une gestion cohérentes des données tout au long du développement et de la maintenance du système.

---
<!-- Bouton 'Retour vers le Sommaire' et Bouton 'Retour vers haut' du document -->
<div align="right">
    <a href="#mcd-modèle-logique-de-données">
        <img src="../../../img/image-docs/icon-vers-le-haut.png" alt="Retour vers le haut" style="width: 25px;" />
    </a>
</div>
<div align="left">
    <a href="/README.md">
        <img src="../../../img/image-docs/summary.png" alt="Retour vers le haut" style="width: 100px;" />
    </a>
</div>