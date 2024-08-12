# Documentation du MERISE (DP)

## <u>La normalisation</u>

La normalisation est un processus qui permet de structurer une base de données de manière à réduire la redondance des données et à éviter les anomalies lors des opérations. Lors de la conception de la base de données pour ce projet, j'ai appliqué les principes de normalisation pour m'assurer que chaque table soit bien organisée et efficace.

<u>**Les différentes Formes Normales :**</u>
- **1NF** (Première Forme Normale) : Assure que chaque colonne contient des valeurs atomiques, c'est-à-dire indivisibles, et que chaque enregistrement est unique.
- **2NF** (Deuxième Forme Normale) : Se base sur la 1NF et garantit que chaque attribut non-clé dépend entièrement de la clé primaire.
- **3NF** (Troisième Forme Normale) : Se base sur la 2NF et élimine les dépendances transitives entre les attributs non-clés, assurant que les attributs dépendent uniquement de la clé primaire.
- **BCNF** (Forme Normale de Boyce-Codd) : Une version renforcée de la 3NF qui résout les cas où la 3NF ne suffit pas à éliminer toutes les anomalies de dépendance.
- **4NF** (Quatrième Forme Normale) : Assure qu'il n'y a pas de dépendances multi-valuées, c'est-à-dire que chaque attribut est indépendant des autres, sauf de la clé primaire.
- **5NF** (Cinquième Forme Normale) : Après avoir atteint la 4NF, est un niveau avancé de normalisation destiné à minimiser la redondance dans les bases de données en décomposant les tables en structures plus petites et plus précises. Également connue sous le nom de projet-join normal form (PJNF)

Dans ce projet, j'ai donc commencé par la 1NF pour m'assurer que chaque colonne contient des valeurs indivisibles, ce qui garantit la simplicité des données. Par exemple, dans la gestion des adresses des patients, j'ai divisé l'adresse en trois colonnes distinctes : adresse, code postal et commune, afin de respecter ce principe de valeurs atomiques. Ensuite, en appliquant la 2NF, j'ai veillé à ce que toutes les informations non-clé soient entièrement dépendantes de la clé primaire, éliminant ainsi les dépendances partielles. Enfin, j'ai appliqué la 3NF pour supprimer les dépendances transitives, garantissant que chaque attribut non-clé dépende uniquement de la clé primaire.

Ces étapes ont permis de concevoir une base de données robuste, minimisant les risques d'erreurs et facilitant la maintenance et l'évolution du système.


## <u>Méthode MERISE</u>

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

## <u>MPD</u>

Mon MPD repose sur les concepts fondamentaux de la méthode MERISE, tels que le Modèle Conceptuel de Données (MCD), le Modèle Logique de Données (MLD), et le Dictionnaire de Données. Ces concepts ont guidé la conception structurée de la base de données, assurant une cohérence et une précision dans le stockage et la gestion des données.

### <u>Structure du MPD</u>

#### Création des Tables :
- Chaque table a été soigneusement définie avec ses colonnes spécifiques et ses types de données. Par exemple, la table Patient inclut des informations comme le nom, le prénom, et le numéro de sécurité sociale.

#### Fonctions et Triggers :
- J'ai inclus des fonctions et des triggers pour gérer automatiquement les dates de création et de modification des enregistrements. Ces éléments assurent que la date et l'heure actuelles sont automatiquement enregistrées lors de l'insertion et de la mise à jour des données.\
- **Exemple** : Le trigger set_creation_date_trigger attribue la date et l'heure de création à chaque nouvel enregistrement dans la table Patient.

#### Insertion de Données Factices :
- Pour tester et manipuler les données, j'ai inséré des données factices dans chaque table. Ces données permettent de vérifier le bon fonctionnement des requêtes et des relations entre les tables.

#### Commentaire du Code :
- J'ai pris soin de commenter le code SQL de manière détaillée. Chaque section, fonction, et trigger est accompagnée de commentaires expliquant leur rôle et leur fonctionnement.\
- **Objectif** : Cette documentation facilite la compréhension du code pour les futurs développeurs, et aide à maintenir une bonne pratique de documentation pour les projets futurs.

Cette approche garantit non seulement que la base de données est bien structurée et fonctionnelle, mais aussi que le code est facile à comprendre et à maintenir. Les commentaires permettent d'assurer une bonne communication des intentions du code, ce qui est crucial pour une collaboration efficace avec les collègues et pour les projets futurs.

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