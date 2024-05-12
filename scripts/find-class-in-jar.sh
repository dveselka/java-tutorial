#!/bin/bash

for i in `find $1 -name "*jar"`
do
  echo $i
  jar tf $i | grep $2 
done
