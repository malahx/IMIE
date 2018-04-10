#!/usr/bin/python

import sys

print("coucou")


def addi(a, b):
    return a + b


if __name__ == "__main__":
    print(addi(int(sys.argv[1]), int(sys.argv[2])))
