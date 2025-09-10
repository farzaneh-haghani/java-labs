<h1>Lab 01D</h1>

Java basics – Arrays and loops

Lab: Loops and arrays
Objective
The objectives of this practical are:
• to get fully up to speed with array definition, creating, filling, and manipulation.
• to fully understand when it is appropriate to use a ‘foreach’ loop as opposed to a ‘for’ loop to process the array.

Part 1 – Getting started!

1. Back in the labs project, created a new class called Program in a package called lab lab4 with a main() method.
2. Declare an array of integers in the main() method as:
   ```java
   int[ ] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };
   ```

Then, without using built-in commands in Java, do these tasks:
• Task 1: Write code to find the sum of every number in numbers
• Task 2: Find the average of these numbers
• Task 3: Find the minimum number in numbers
• Task 4: Find the maximum number in numbers
• Task 5: Find the index of number zero in numbers

Part 2 – Calculating the grades for five students
Step-by-step

1. We will revisit the grades() method that you wrote before but this time we will process many grades rather than just one.
2. Create a method called getGrade like:

String getGrade(int mark) 3. Copy the code for processing grades to this method.

4. Back in the main() method, create an array of five names (String[ ]) called students and then create an array of five integers called marks to hold the marks for our five students.
   Fill the students[ ] array with five names and the marks[ ] array with five marks.
5. Use a for or while loop to determine the grade for each mark in the marks array and display it alongside the corresponding student name from the students array.

Part 2 – How long does it take to double your money?
Assuming an initial investment of say £100, how many years does it take to grow to £200 given an interest rate of 5%?
Step-by-step

1. Create a new method In account() in the Lab6 class.
2. Create suitable variables to store the initial money, current money (at the end of each year), interest rate (5%), and years (to double the money).
3. Write code to calculate the number of years it takes to get £200.
   Tip: Use a while loop which stops when the current money == £200.

Part 3 – Nested loop practice
Ensure you can code up nested loops, understanding the full sequence in which everything runs. Effectively use the outer and ‘inner’ loop variables together in a nested loop. In this part you'll produce a multiplication table.
Step-by-step

1. Create a method called multiplicationTable() in the Lab.
2. We want you to produce this output on the console.
```
   1 2 3 4 5 6 7 8 9 10
   2 4 6 8 10 12 14 16 18 20
   3 6 9 12 15 18 21 24 27 30
   4 8 12 16 20 24 28 32 36 40
   5 10 15 20 25 30 35 40 45 50
   6 12 18 24 30 36 42 48 54 60
   7 14 21 28 35 42 49 56 63 70
   8 16 24 32 40 48 56 64 72 80
   9 18 27 36 45 54 63 72 81 90
   10 20 30 40 50 60 70 80 90 100
```

Tip: Two nested for loops (count from 1..10) are best for this.
Also, to print the product of two variables called row and col in five spaces, use a statement like:
System.out.printf("%5d", col \* row);

** End **
