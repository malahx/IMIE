#include <stdio.h>

int main(int argc, char *argv[])
{
	char name1[21], name2[21];
	int pomme1, pomme2, panier;

	printf("Saisir le nom du personnage 1 :\n");
	scanf(" %20[a-zA-Z]", name1);

	printf("Saisir le nom du personnage 2 :\n");
	scanf(" %20[a-zA-Z]", name2);

	printf("Saisir le nombre de pomme du personnage 1 :\n");
	scanf(" %d", &pomme1);

	printf("Saisir le nombre de pomme du personnage 2 :\n");
	scanf(" %d", &pomme2);

	printf("Personnage 1: %s pommes(%d)\n", name1, pomme1);
	printf("Personnage 2: %s pommes(%d)\n", name2, pomme2);

	panier = pomme1 + pomme2;
	printf("Somme: %d\n", panier);
	return 0;
}