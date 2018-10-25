Q.1b Le test de ces constructeurs utilisent les opérations getX et getY. Ne trouvez-vous pas cela étrange qu’un test utilise d’autres opérations ? Que faire ?
	 Non il utilise les accesseurs en lecture et écriture, cela est normal car il peut pas accéder directement aux attributs de la classe a tester
Q.2b Est-ce que votre code est sûr lorsque toutes les instructions sont couvertes par au moins un test ?
	 Le code deviens sûr lorsque toutes les instructions sont couvertes par les tests mais cela ne garantit pas un code sans erreur
Q.3a Expliquez en quoi il est impossible de tester en l’état cette opération. >> On veut donc utiliser le principe du Mock pour tester cette opération.
     Il est impossible de tester cette méthode car elle affecte des nombres aléatoires au point qu'on ne peut vérifier avec des Assertions