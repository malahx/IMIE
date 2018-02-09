cmake_minimum_required(VERSION 3.10)

project(Mastermind)

set(CPP 
	main.cpp
	Chain.cpp
	RandMaster.cpp)

add_executable(mastermind.o ${CPP})