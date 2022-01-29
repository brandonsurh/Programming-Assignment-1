# Programming-Assignment-1
To run this file, go to the directory and compile it with
javac pa1.java

then do

java p1.java



My approach was to split up the range of numbers for the algorithms to mark off. This was done by splitting the 10^8 by 8 and giving each of the 8 threads a range to mark through. This approach didn't work because the algorithm works off of sequential markings from past numbers. Without this, the algorithm doesn't know which prime number to use next and fails to mark off anything.
