XspeedIt
========

### Exécution (jar)
Il est de bon ton d'éviter les fichiers binaires dans les projets git. Vous trouverez donc le fichier jar résultant du code au commit [31eef29](https://github.com/cs2MM47BGJ3Eiht7y5u9/xspeedit/commit/31eef2939ea94a1c1db0d62161f986e2c4c0fbc4) sur ce lien : [xspeedit.jar](https://www.auzias.net/xspeedit.jar) signé avec la même clef privée utilisée pour signer les commits : [signature](https://www.auzias.net/xspeedit.jar.asc), [clef publique](https://www.auzias.net/cs2MM47BGJ3Eiht7y5u9-github@mael.auzias.net). L'exécution requiert un argument qui est le nombre d'articles à emballer.

### Supposition
Pour développer ce test, il a été supposé que l'emballeur, [_wrapper_](src/main/org/java/Wrapper.java), n'était pas requis d'emballer les articles dans l'ordre de production mais disposait d'un espace de stockage pour optimiser. Cet espace de stockage n'est pas limité dans cette version et correspond au nombre d'articles à emballer.

Déformation professionnelle oblige et ne connaissant pas les pratiques chez vous, j'ai codé en anglais.

Dans l'affichage des résultat un nombre de cartons d'emballage est estimé, nommé `guessedBoxesNumber` [cf `Wrapper`](src/main/org/java/Wrapper.java#L45). Ce nombre de cartons est inférieur au nombre optimal de cartons mais peut servir comme référence. Ce nombre correspond au nombre de carton si les articles pouvait être coupés dans le but de remplir **tous** les cartons jusqu'à leur capacité maximale.

### Commentaires
Je n'ai pas développé ce test avec mon vrai compte github de peur que mes supérieurs voient cette activité.

Les commits ont été signés avec une nouvelle clef gpg, temporaire.

Vu que le projet était simple, que j'étais seul à programmer et n'avais pas de bug-tracking à disposition tous les commits ont été poussés sur `master` directement. Git-flow est à préférer dans des conditions différentes (PS : [désolé pour la PR involontaire](https://github.com/voyages-sncf-technologies/xspeedit/pull/6)).


### Possibilités d'amélioration
 - [ ] utiliser une propriété système pour le nombre d'articles à emballer
 - [ ] utiliser une propriété système pour définir la capacité maximale de l'espace de stockage des articles (un produit emballé libérant alors un espace pour un nouvel article)
 - [ ] utiliser une propriété système pour définir une graine, [_seed_](src/main/org/java/Producer.java#L19), pour l'aléatoire
 - [ ] laisser la possibilité à l'utilisateur de définir sa propre liste d'articles à emballer (soit en argument soit via `stdin`)
 - [ ] programmer un emballeur, [_wrapper_](src/main/org/java/Wrapper.java), orienté stream (qui ne pourrait donc pas trier --mais c'est un problème trivial--)
 - [ ] plus de tests (y en a-t-il un jour assez?)
 - [ ] ajout d'un `CHANGELOG` (aucun livrable qui se respecte ne devrait être dépourvu de `CHANGELOG`)
 - [ ] un `pom.xml` ou un `module.ivy` (plus pour la version et le nom que pour les dépendances)

---

XspeedIt est une société d'import / export ayant robotisé toute sa chaîne d'emballage de colis.  
Elle souhaite trouver un algorithme permettant à ses robots d'optimiser le nombre de cartons d'emballage utilisés.

Les articles à emballer sont de taille variable, représentée par un entier compris entre 1 et 9.  
Chaque carton a une capacité de contenance de 10.  
Ainsi, un carton peut par exemple contenir un article de taille 3, un article de taille 1, et un article de taille 6.

La chaîne d'articles à emballer est représentée par une suite de chiffres, chacun représentant un article par sa taille.  
Après traitement par le robot d'emballage, la chaîne est séparée par des "/" pour représenter les articles contenus dans un carton.

*Exemple*  
```python
Chaîne d'articles en entrée : 163841689525773  
Chaîne d'articles emballés  : 163/8/41/6/8/9/52/5/7/73
```

L'algorithme actuel du robot d'emballage est très basique.  
Il prend les articles les uns après les autres, et les mets dans un carton.  
Si la taille totale dépasse la contenance du carton, le robot met l'article dans le carton suivant.

Objectif
--------

Implémenter une application qui permettrait de maximiser le nombre d'articles par carton, en utilisant un langage pouvant être exécuté sur une JVM 1.7 minimum ou en node.js.  
L'ordre des cartons et des articles n'a pas d'importance.

*Exemple*  
```python
Articles      : 163841689525773  
Robot actuel  : 163/8/41/6/8/9/52/5/7/73 => 10 cartons utilisés  
Robot optimisé: 163/82/46/19/8/55/73/7   => 8  cartons utilisés
```
