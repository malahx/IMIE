#include <stdio.h>

int main(int argc, char *argv[])
{
	char name[21] = {'\0'}, c;
	int i = 0, j = 0, k = 0;
	printf("Quel est votre nom (taille max: %d) ? ", sizeof(name));
	scanf(" %20[a-zA-Z]", name);

	do {
		printf("1) afficher votre nom avec un espace à chaque caractère\n");
		printf("2) afficher votre nom à l'envers\n");
		printf("3) afficher un caractère sur deux de votre nom\n");
		printf("Que voulez vous faire ?\n");
		while ((c = getchar()) != '\n' && c != EOF);
		scanf(" %d", &i);
	} while (i < 1 || i > 3);

	while (name[k] != '\0') {
		k++;
	}

	printf("Votre nom possède %d caractère(s).\n", k);
	switch (i) {
		case 1:
			printf("1) afficher votre nom avec un espace à chaque caractère : ");
			for (j = 0; j < k; j++) {
				printf("%c ", name[j]);
			}
			break;
		case 2:
			printf("2) afficher votre nom à l'envers : ");
			for (j = k -1; j >= 0; j--) {
				printf("%c", name[j]);
			}
			break;
		case 3:
			printf("3) afficher un caractère sur deux de votre nom : ");
			for (j = 0; j < k; j += 2) {
				printf("%c", name[j]);
			}
			break;
	}
	printf("\n");
	return 0;
}