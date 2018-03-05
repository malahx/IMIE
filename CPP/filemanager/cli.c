#include <stdio.h>

#define MODE 'm'
#define COPIE 'o'

void printFile(FILE* file) {
    int c;
    while ((c = getc(file)) != EOF) {
        putchar(c);
    }
    fclose(file);
}
void copieFile(FILE* file, char* fileName) {
    FILE *copie = fopen(fileName, "w+");
    char c;
    while ((c = (char) getc(file)) != EOF) {
        fputc(c, copie);
    }
    fclose(file);
    fclose(copie);
}

int main(int argc, char *argv[]) {
    char* mode = "r";
    char* copieFileName = NULL;
    if (argc < 2) {
        printf("Need a filename ...\n");
        return 1;
    }
    char* fileName = argv[1];
    for (int i = 2; i < argc; ++i) {
        printf("%s\n", argv[i]);
        if (argv[i][0] == '-' && argc > i + 1) {
            switch (argv[i][1]) {
                case MODE: 
                    mode = argv[i +1]; 
                    break;
                case COPIE: 
                    copieFileName = argv[i +1]; 
                    break;
            }
        }
    } 
    printf("filename: %s\n", fileName);
    printf("mode: %s\n", mode);
    printf("copie to: %s\n", copieFileName);
    FILE *file = fopen(fileName, mode);
    if (copieFileName == NULL) {
        printFile(file);
    } else {
        copieFile(file, copieFileName);
    }
    return 0;
}