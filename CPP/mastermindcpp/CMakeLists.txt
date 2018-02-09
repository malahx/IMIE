cmake_minimum_required(VERSION 3.10)

project(Mastermind)

set(CPP 
	main.cpp
	Chain.cpp)

add_library(RandMaster SHARED RandMaster.cpp)

set(APP mastermind)

add_executable(${APP} ${CPP})

target_link_libraries(${APP} RandMaster)