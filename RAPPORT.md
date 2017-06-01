**MARTIN Gaetan**
**JOYMANGUL Jensen**
**MOISSON Matthieu**

# Rapport TP4

## Question 1
Les améliorations possibles sont répertoriées dans les issues de GitHub

https://github.com/PolytechLyon/4a-isi3-tp4-2016-2017-groupe-1-martin_joymangul/issues

## Question 2
###Motif avant le refactoring
![Package mvc-flocking](images/UMLAvantModif.png)

###Motif aprés refactoring
![Package mvc-flocking](images/Diagramme de Classe.png)
## Question 3
*Rien à rédiger*

## Question 4
*Rien à rédiger*

## Question 5 / Question 6
A ce stade du projet, nous avons pu identifier trois environnements pour le mouvement de notre tortue :

1. Environnement contrôlé
2. Environnement automatique
3. Environnement flocking

Ses trois environnements possèdent beaucoup d’attributs ainsi que plusieurs méthodes en en communs. 
Ainsi nous avons implémenté une classe Abstraite `AbstractEnvironment` afin d’éviter la duplication de code par exemple l’algorithme d’évitement est commun des trois environnements. De plus nous avons obtenu une plus grande souplesse durant la création des instances de ses environnement dans notre contrôleur.

### Flocking
Concernant le flocking nous avons utilisé les fonctionnalités présentes en Java 8 pour calculer la moyenne de l’angle pour la direction ainsi que la moyennes des vitesses pour tous les tortues voisines.

```java
Double avg_direction = neighbours
        .stream()
        .mapToInt(ITurtle::getDirection)
        .average()
        .orElse(1);

Double avg_speed = neighbours
        .stream()
        .mapToInt(ITurtle::getSpeed)
        .average()
        .orElse(1);
```

En cour de projet le client a décidé de faire un flocking par couleur et ainsi les tortues se regrouperont par couleurs. Grâce à l’architecture que nous avons utilisé ce changement ne se fut pas un grand problème. En effet, nous avons seulement modifié une condition pour calculer les voisins d’une tortue. Nous avons rajouté la ligne suivante :
``` java
turtle.getColor() == currentTurtle.getColor() ;
```

## Question 7
*Rien à rédiger*

## Question 8
*Expliquer l'intérêt du mock*

## Question 9
*Montrer les résultats de vos rapports d'analyse*

## Question 10
*Rien à rédiger*
