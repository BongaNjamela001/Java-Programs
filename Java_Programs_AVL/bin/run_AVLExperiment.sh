#!/bin/bash

start=0
end=20
a=495

mkdir ExperimentResults

for ((i=$start; i<=$end; i++));
do
echo "Trial 0$i"
java AVLExperiment "$i"
done

for ((i=$start; i<$end;i++))
do
j=$((i*a))
mv instrumentation$j.txt ExperimentResults
done 

for ((i=$start; i<$end;i++))
do
j=$((i*a))
mv vaccines$j.txt ExperimentResults
done
mv "instrumentation9919.txt" ExperimentResults
mv "vaccines9919.txt" ExperimentResults
echo "DONE. PROGRAM QUITTING"
