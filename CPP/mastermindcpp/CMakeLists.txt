cmake_minimum_required(VERSION 3.10)

project(Mastermind)

set(APP mastermind)

set(CPP 
	src/main.cpp
	src/Chain.cpp)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY lib)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY arch)

include_directories(src src/utils)

add_library(RandMaster SHARED src/utils/RandMaster.cpp)

add_executable(${APP} ${CPP})

target_link_libraries(${APP} RandMaster)