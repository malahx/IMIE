#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

/*
 * Mastermind
 */

typedef struct masterMind {
    int good;
    int bad;
    int count;
    char result[4];
    char entered[4];
    char treatResult[4];
    char treatEntered[4];
} masterMind;

void reset(masterMind* m) {
    m->good = 0;
    m->bad = 0;
    for (int i = 0; i < sizeof(m->treatResult); ++i) {
        m->treatResult[i] = false;
    }
    for (int i = 0; i < sizeof(m->treatEntered); ++i) {
        m->treatEntered[i] = false;
    }
}

char randMaster() {
    char val[6] = {'Y', 'B', 'R', 'G', 'O', 'W'};
    return val[rand() % 6];
}

masterMind* init() {
    masterMind* m = (masterMind*) malloc(sizeof(masterMind));
    reset(m);
    m->count = 10;
    for (int i = 0; i < sizeof(m->result); ++i) {
        m->result[i] = randMaster();
    }
    for (int i = 0; i < sizeof(m->entered); ++i) {
        m->entered[i] = EOF;
    }
    return m;
}

void print_result(int good) {
    if (good == 4) {
        printf("You have win\n");
    } else {
        printf("You have lost\n");
    }
}

void findGood(masterMind* m) {
    for (int i = 0; i < 4; ++i) {
        if (m->result[i] == m->entered[i]) {
            ++m->good;
            m->treatEntered[i] = true;
            m->treatResult[i] = true;
            continue;
        }
    }
}

void findBad(masterMind* m) {
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            if (!m->treatResult[i] && !m->treatEntered[j] && m->result[i] == m->entered[j]) {
                ++m->bad;
                m->treatResult[i] = true;
                m->treatEntered[j] = true;
                continue;
            }
        }
    }
}

int main() {
    srand ((unsigned int) time (NULL));
    masterMind* m = init();
//    printf("%c%c%c%c\n",m->result[0],m->result[1],m->result[2],m->result[3]);
    printf("MASTERMIND\n");
    printf("Enter 4 character from YBRGOW:\n");
    do {
        reset(m);
        scanf(" %4[YBRGOW]", m->entered);
        findGood(m);
        findBad(m);
        --m->count;
        printf("Good: %d / Bad: %d\n", m->good, m->bad);
        if (m->good != 4 && m->count >= 0) {
            printf("You have %d try\n", m->count);
        }
        char c;
        while ((c = (char) getchar()) != '\n' && c != EOF);
    } while (m->good != 4 && m->count >= 0);
    print_result(m->good);
    return 0;
}