//
// Created by malah on 07/02/18.
//

#include "RandMaster.hpp"

char RandMaster::get() const {
    std::string values = RANDMASTER_VALUES;
    return values.at(std::rand() % values.length());
}
