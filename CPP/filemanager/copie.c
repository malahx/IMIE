#include <stdio.h>

int main() {
    FILE *file = fopen("/home/malah/Code/IMIE/CPP/filemake/tocopie", "r");
    FILE *copie = fopen("/home/malah/Code/IMIE/CPP/filemake/thecopie", "w+");
    char c;
    while ((c = (char) getc(file)) != EOF) {
        fputc(c, copie);
    }
    fclose(file);
    fclose(copie);
    return 0;
}