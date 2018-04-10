#!/usr/bin/python

import sys

print("coucou")


def addi(a, b):
    return a + b


def write(f, data):
    file = open(f, "w")
    file.write(data)
    file.close()


def read(f):
    file = open(f, "r")
    lines = file.readlines()
    print(lines)


if __name__ == "__main__":
    print(addi(int(sys.argv[1]), int(sys.argv[2])))
    write("test.txt", "a\nb\nc")
    read("test.txt")
