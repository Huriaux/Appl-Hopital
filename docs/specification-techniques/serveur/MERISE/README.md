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

## <u>Mise en place de la BDD (Docker-compose, PostgreSQL, pgAdmin, MPD)</u>

Pour mettre en place la base de données, j’ai utilisé Docker, PostgreSQL comme système de gestion de bases de données, et pgAdmin pour l'administration. Voici comment j'ai procédé, étape par étape.

Tout d'abord, j'ai créé un fichier **`docker-compose.yml`**. Ce fichier décrit comment configurer et lancer plusieurs services (comme ici, une base de données PostgreSQL et pgAdmin) dans des conteneurs Docker. 

<u>Dans ce fichier, j'ai défini deux services :</u> 
- Un **service PostgreSQL** utilise l'image officielle de PostgreSQL, configure les informations d'identification de la base de données (utilisateur, mot de passe, et nom de la base), et définit les ports à utiliser. 
- Et un **service pgAdmin** utilise une image pour cet outil d'administration, avec des paramètres pour l'email et le mot de passe de connexion, ainsi qu'un port pour y accéder depuis un navigateur web.

Le fichier docker-compose.yml prêt, pour **démarrer les conteneurs**, j'ai utilisé la commande `docker-compose up -d` qui permet de lancer les services définis dans le fichier en arrière-plan.

Ensuite, j'ai **vérifié que les conteneurs étaient bien lancés** avec la commande `docker ps`. Elle m'a permis de lister tous les conteneurs en cours d'exécution avec leurs détails, comme les ports utilisés.

 Ainsi, le conteneur en marche, j'ai pu **accéder à l'interface de pgAdmin** sur mon navigateur web en tapant l'URL http://localhost:5050. Sur la page de connexion de pgAdmin, j'ai entré l'email et le mot de passe que j'avais définis dans le fichier docker-compose.yml.

Une fois connecté à pgAdmin, il m'a fallu **ajouter un nouveau serveur** pour me connecter à PostgreSQL. Pour ce faire, j'ai cliqué sur "Add New Server" dans pgAdmin. Dans la fenêtre qui s'est ouverte, j'ai d'abord attribué un nom au serveur, comme "AppHopital", afin de pouvoir l'identifier facilement.

Ensuite, dans l'**onglet "Connection"**, j'ai configuré les détails nécessaires pour établir la connexion avec la base de données PostgreSQL. J'ai spécifié postgres_container comme nom d'hôte ("Host"), ce qui correspond au nom du conteneur Docker exécutant PostgreSQL. Pour les droits d’accès, j'ai entré dbuser comme "Username" et dbpass comme "Password". Ces informations correspondent aux paramètres définis dans le fichier docker-compose.yml, qui détermine les droits d'accès pour les utilisateurs de la base de données.

En définissant ces paramètres, j'ai assuré que pgAdmin pouvait se connecter correctement au conteneur PostgreSQL avec les bons privilèges. Cela permet de gérer et de manipuler la base de données via l'interface de pgAdmin tout en respectant les configurations de sécurité et d'accès établies.

Mon **Modèle Physique de Données (MPD)** repose sur les concepts fondamentaux de la méthode MERISE, tels que le MCD, le MLD et le Dictionnaire de Données. Ces concepts ont guidé la conception structurée de la base de données, assurant une cohérence et une précision dans le stockage et la gestion des données. 

<u>Permettez-moi de vous décrire la structure de mon MPD :</u>\
J'ai tout d’abord créé une table pour stocker les informations des patients. Chaque table de ma base de données a été soigneusement définie avec ses colonnes spécifiques et ses types de données. Par exemple, la table Patient inclut des informations telles que le nom, le prénom, la date de naissance, et le numéro de sécurité sociale. J'ai également ajouté des contraintes pour garantir l'unicité de certaines données, comme le numéro de sécurité sociale et le numéro de téléphone.

Pour automatiser la gestion des dates de création et de modification des enregistrements, j'ai créé des fonctions et des triggers (déclencheurs). Par exemple, la fonction set_creation_date() est appelée à chaque fois qu'un nouveau patient est ajouté, et elle enregistre la date et l'heure actuelles dans la colonne dt_creation. La fonction set_modification_date() met à jour la colonne dt_modification chaque fois que les informations d'un patient existant sont modifiées. Ces fonctions sont ensuite associées à des triggers, comme le set_creation_date_trigger, qui s'exécutent automatiquement lors des insertions ou des modifications dans la table Patient.

Pour **tester et manipuler les données**, j'ai inséré des données factices dans chaque table. Ces données m'ont permis de vérifier le bon fonctionnement des requêtes et des relations entre les tables.

J'ai pris soin de commenter le code SQL de manière détaillée. Chaque section, fonction, et trigger est accompagné de commentaires expliquant leur rôle et leur fonctionnement. J'ai fais de même pour le fichier docker-compose. Cette documentation facilite la compréhension du code pour les futurs développeurs et aide à maintenir une bonne pratique de documentation pour les projets futurs.

En résumé, ce processus m'a permis de mettre en place une base de données gérée par PostgreSQL, administrée via pgAdmin, avec des automatisations pour suivre les dates de création et de modification des enregistrements, le tout en utilisant Docker pour simplifier la gestion et l'isolation de ces services.


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