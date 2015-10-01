#!/bin/sh

for line in `cat services.pid`
do 
echo "Killing process with PID :"$line
kill -9 $line &
done

rm -rf services.pid
