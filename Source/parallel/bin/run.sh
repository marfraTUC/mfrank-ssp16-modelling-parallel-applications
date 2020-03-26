#!/bin/bash

echo "2 Cores - start"
cd ./cores/2
java de/tuchemnitz/se/openmp/Main
cd .. 
cd .. 
echo "2 Cores - finished"

echo "4 Cores - start"
cd ./cores/4
java de/tuchemnitz/se/openmp/Main
cd .. 
cd .. 
echo "4 Cores - finished"

echo "8 Cores - start"
cd ./cores/8
java de/tuchemnitz/se/openmp/Main
cd .. 
cd .. 
echo "8 Cores - finished"

echo "16 Cores - start"
cd ./cores/16
java de/tuchemnitz/se/openmp/Main
cd .. 
cd .. 
echo "16 Cores - finished"