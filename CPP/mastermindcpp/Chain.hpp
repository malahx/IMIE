//
// Created by malah on 07/02/18.
//

#include <iostream>
#include "RandMaster.hpp"

#ifndef TP_CHAIN_H
#define TP_CHAIN_H

#define NB_VALUE 4

class Chain {

public:

    Chain(RandMaster rand) : rand(rand) {
        this->resetValues();
        this->resetTreats();
    };

    Chain(RandMaster rand, std::string values) : rand(rand), values(values) {
        this->resetTreats();
    };

    void resetValues();

    void resetTreats();

    int findGood(Chain &c);

    int findBad(Chain &c);

    std::string getValues();

private:

    std::string values;

    bool treats[NB_VALUE];

    RandMaster rand;

};


#endif //TP_CHAIN_H
