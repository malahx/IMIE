#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/*
 * Mastermind
 */

typedef struct chain {
    char values[4];
    int treats[4];
} chain;

char randMaster() {
    char val[6] = {'Y', 'B', 'R', 'G', 'O', 'W'};
    return val[rand() % 6];
}

void resetTreats(chain *v) {
    for (int i = 0; i < 4; ++i) {
        v->treats[i] = 0;
    }
}

void resetValues(chain *v) {
    for (int i = 0; i < 4; ++i) {
        v->values[i] = randMaster();
    }
}

chain *initChain() {
    chain *v = (chain *) malloc(sizeof(chain));
    resetValues(v);
    resetTreats(v);
    return v;
}

int findGood(chain *result, chain *entered) {
    int good = 0;
    for (int i = 0; i < 4; ++i) {
        if (result->values[i] == entered->values[i]) {
            ++good;
            entered->treats[i] = 1;
            result->treats[i] = 1;
            continue;
        }
    }
    return good;
}

int findBad(chain *result, chain *entered) {
    int bad = 0;
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            if (!entered->treats[i] && !result->treats[j] && entered->values[i] == result->values[j]) {
                ++bad;
                result->treats[j] = 1;
                continue;
            }
        }
    }
    return bad;
}

void print_result(int good) {
    if (good == 4) {
        printf("You have win\n");
    } else {
        printf("You have lost\n");
    }
}

int main() {
    srand((unsigned int) time(NULL));
    int good = 0, bad = 0, count = 10;
    chain *result = initChain();
    printf("%c%c%c%c\n", result->values[0], result->values[1], result->values[2], result->values[3]);
    printf("MASTERMIND\n");
    printf("Enter 4 character from YBRGOW:\n");
    do {
        resetTreats(result);
        chain *entered = initChain();
        scanf(" %4[YBRGOW]", entered->values);
        good = findGood(result, entered);
        bad = findBad(result, entered);
        --count;
        printf("Good: %d / Bad: %d\n", good, bad);
        if (good != 4 && count >= 0) {
            printf("You have %d try\n", count);
        }
        char c;
        while ((c = (char) getchar()) != '\n' && c != EOF);
    } while (good != 4 && count >= 0);
    print_result(good);
    return 0;
}