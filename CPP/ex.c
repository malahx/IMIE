#include <stdio.h>

typedef unsigned int uint;

typedef struct position {
	uint x;
	uint y;
} position;

void printPosition(position p) {
	printf("[%d;%d]\n", p.x, p.y);
}

int main()
{
	int i = 3;
	int* p = &i;

	*p = 42;

	printf("%d\n", i);

	position p;
	p.x = 4;
	p.y = 2;

	printPosition(p);

	return 0;
}