//
// Created by malah on 07/02/18.
//

#include "Chain.hpp"

void Chain::resetValues() {
    for (auto i = 0; i < NB_VALUE; ++i) {
        this->values += rand.get();
    }
};

void Chain::resetTreats() {
    for (bool &treat : this->treats) {
        treat = false;
    }
};

int Chain::findGood(Chain &c) {
    int good = 0;
    for (int i = 0; i < NB_VALUE; ++i) {
        if (this->values[i] == c.values[i]) {
            ++good;
            this->treats[i] = true;
            c.treats[i] = true;
            continue;
        }
    }
    return good;
};

int Chain::findBad(Chain &c) {
    int bad = 0;
    for (int i = 0; i < NB_VALUE; ++i) {
        for (int j = 0; j < NB_VALUE; ++j) {
            if (!this->treats[i] && !c.treats[j] && this->values[i] == c.values[j]) {
                ++bad;
                c.treats[j] = true;
                continue;
            }
        }
    }
    return bad;
};

std::string Chain::getValues() {
    return this->values;
}
