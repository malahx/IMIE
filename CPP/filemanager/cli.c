#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

#define MODE 'm'
#define COPIE 'o'
#define BIN 'b'

typedef struct config {
    char* fromFileName;
    char* toFileName;
    char* mode;
    int binary;
} config;

void printFile(config* cfg) {
    FILE *from = fopen(cfg->fromFileName, cfg->mode);
    int c;
    while ((c = getc(from)) != EOF) {
        putchar(c);
    }
    fclose(from);
}
void copieFile(config* cfg) {
    FILE *from = fopen(cfg->fromFileName, cfg->mode);
    FILE *to = fopen(cfg->toFileName, "w+");
    char c;
    while ((c = (char) getc(from)) != EOF) {
        fputc(c, to);
    }
    fclose(from);
    fclose(to);
}
void printFileBin(config* cfg) {
    FILE *from = fopen(cfg->fromFileName, "rb");
    struct stat info;
    stat(cfg->fromFileName, &info);
    char *content = malloc(info.st_size);
    fread(content, info.st_size, 1, from);
    fclose(from);
    for (int i = 0; content[i] != '\0'; ++i) {
        printf("%c", content[i]);
    }
}
void copieFileBin(config* cfg) {
    FILE *from = fopen(cfg->fromFileName, "rb");
    struct stat info;
    stat(cfg->fromFileName, &info);
    char *content = malloc(info.st_size);
    size_t blocks_read = fread(content, info.st_size, 1, from);
    FILE *to = fopen(cfg->toFileName, "wb");
    fwrite(content, blocks_read, info.st_size, to);
    fclose(from);
    fclose(to);
}

config* initConfig(char* fromFileName) {
    config* cfg = (config *) malloc(sizeof(config));
    cfg->mode = "r";
    cfg->fromFileName = fromFileName;
    cfg->toFileName = NULL;
    cfg->binary = 0;
    return cfg;
}

void parseConfig(config* cfg, int argc, char* argv[]) {
    for (int i = 2; i < argc; ++i) {
        if (argv[i][0] == '-') {
            switch (argv[i][1]) {
                case MODE:
                    if (argc > i + 1) {
                        cfg->mode = argv[i +1];
                    }
                    break;
                case COPIE:
                    if (argc > i + 1) {
                        cfg->toFileName = argv[i +1];
                    }
                    break;
                case BIN:
                    cfg->binary = 1;
                    break;
            }
        }
    }
}
void drawConfig(config* cfg) {
    printf("filename: %s\n", cfg->fromFileName);
    printf("binary mode: %d\n", cfg->binary);
    if (cfg->binary == 0) {
        printf("mode: %s\n", cfg->mode);
    }
    if (cfg->toFileName != NULL) {
        printf("copie to: %s\n", cfg->toFileName);
    }
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Need a filename ...\n");
        return 1;
    }
    config* cfg = initConfig(argv[1]);
    parseConfig(cfg, argc, argv);
    drawConfig(cfg);
    if (cfg->binary == 0) {
        cfg->toFileName == NULL ? printFile(cfg) ? copieFile(cfg);
    } else {
        cfg->toFileName == NULL ? printFileBin(cfg) : copieFileBin(cfg);
    }
    return 0;
}