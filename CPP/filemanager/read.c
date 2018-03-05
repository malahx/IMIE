#include <stdio.h>

int main() {
    FILE *file = fopen("/home/malah/Code/IMIE/CPP/filemake/tocopie", "r");
    int c;
    while ((c = getc(file)) != EOF) {
        putchar(c);
    }
    fclose(file);
    return 0;
}