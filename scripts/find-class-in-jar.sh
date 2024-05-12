#!/bin/bash

for i in `find $1 -name "*jar"`
do
  jar tf $i | grep $2 
  if [ $? -eq 0 ]; then
    echo $i
   jar tf $i | grep $2 
  fi

done
