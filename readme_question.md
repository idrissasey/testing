Q.1b Le test de ces constructeurs utilisent les op�rations getX et getY. Ne trouvez-vous pas cela �trange qu�un test utilise d�autres op�rations ? Que faire ?
	 Non il utilise les accesseurs en lecture et �criture, cela est normal car il peut pas acc�der directement aux attributs de la classe a tester
Q.2b Est-ce que votre code est s�r lorsque toutes les instructions sont couvertes par au moins un test ?
	 Le code deviens s�r lorsque toutes les instructions sont couvertes par les tests mais cela ne garantit pas un code sans erreur
Q.3a Expliquez en quoi il est impossible de tester en l��tat cette op�ration. >> On veut donc utiliser le principe du Mock pour tester cette op�ration.
     Il est impossible de tester cette m�thode car elle affecte des nombres al�atoires au point qu'on ne peut v�rifier avec des Assertions