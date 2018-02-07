#include <iostream>
#include <ctime>
#include "Chain.hpp"

std::string getValues();

void print_result(int good);

int main() {
    std::srand(static_cast<unsigned int>(std::time(nullptr)));
    int good = 0, bad = 0, count = 10;
    RandMaster rand = RandMaster();
    Chain result = Chain(rand);
    std::cout << "MASTERMIND" << std::endl;
    std::cout << "Enter " << NB_VALUE << " character from " << RANDMASTER_VALUES << ":" << std::endl;
//    std::cout << result.getValues() << std::endl;
    do {
        result.resetTreats();
        Chain entered = Chain(rand, getValues());
        good = entered.findGood(result);
        bad = entered.findBad(result);
        std::cout << "Good: " << good << " / Bad: " << bad << std::endl;
        --count;
        if (good != NB_VALUE && count >= 0) {
            std::cout << "You have  " << count << " try" << std::endl;
        }
    } while (good != NB_VALUE && count >= 0);
    print_result(good);
    return EXIT_SUCCESS;
}

std::string getValues() {
    std::__cxx11::string values;
    while (!(std::cin >> values) || values.length() != NB_VALUE) {
        std::cin.clear();
        std::cout << "Wrong value, reenter." << std::endl;
    }
    return values;
}

void print_result(int good) {
    if (good == NB_VALUE) {
        std::cout << "You have win" << std::endl;
    } else {
        std::cout << "You have lost" << std::endl;
    }
}