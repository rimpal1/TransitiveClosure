# Steps to run the program

1. `cd {WORKDIR}/CS610_Dijkstra_PA3`
2. Compile java files. `javac *.java`
3. Run the Main method. `java TransitiveClosure`
4. Provide value for the input prompt, and the program will provide the expected result.
  * The input should have first row as total vertices,
  * Second row as starting and ending node
  * It must have 3rd column from 3rd row as weight of each arc
  * It must include '#' sign at the end of input graph to terminate.
  * Please find the sample inputs in end of "TransitiveClosure.java" file in comments

Please consider the below sample input:

```
8 
5 8 
1 2 3 
2 3 1 
3 4 1 
4 5 2 
5 6 3 
6 7 4 
7 8 2 
8 1 6 
#
```
   

