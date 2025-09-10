<h1>Lab 01A</h1>

Java basics – Getting started

Lab: Introduction to Java and Eclipse
Objective
In this lab, you will:
• create a Console program using the Eclipse IDE.
• run the program.

Overview
Eclipse is the development tool used by many Java developers and throughout this course. This lab will show you how to create and run a Java program.

Step-by-step
Creating a new Java application

1. Launch Eclipse and type C:\Labs as the location for your ‘workspace’. (You may choose a different location but make a note of where it is.)
2. Dismiss the Welcome window if it appears.
3. Choose menu option File > New > Java Project.

4. Type the following project name. If the default location is the one you want to use, leave it as it is; otherwise, uncheck ‘Use default location’ and enter your choice of folder. Accept the other default settings:

5. Select ‘Finish’.
6. Right Select on the labs > src node and select New > class.
7. Type lab1 as package name and select public static_void main(String[] args).  
   Select ‘Finish’. (This step will be left out from now on.)

Writing the code 8. In the Program class's main method, type the following:

```java
package lab1;

       public class Program {
              public static void main(String[] args) {
                  System.out.println("Hello, world!");
              }
       }
```

Tip: Type syso followed by Ctrl-Space to type System.out.println
Make sure you make full use of this time saving editor command.

Building and running the program 9. Compiling the program is done by saving your code (Ctrl-s). 10. Press Ctrl+F11 to run the program or select the green Run icon.
A Console window will become active at the bottom of Eclipse.
Please view the output for the println messages.

Building and running the program using command line 11. Make a folder in \labs called test. 12. Copy the code you created above to a file called Program.java. 13. Open command line. 14. Type: cd \labs\temp top navigate to the \labs\temp folder. 15. Type the following to compile your code: javac -d bin .\Program.java 16. Explore the directory structure created. 17. Navigate to the bin folder: cd \labs\test\bin 18. Run your program by typing: java lab1.Program

Store your files using GIT
Objectives:
In this section, you will store all your files using Git commands and use the same method to push your files to a cloud repository on GitHub.

1. Install Git on your PC if you’ve not installed it already.
   Please select the links below for Mac or windows PCs.
   (Alternatively, use QA’s provided Virtual PCs.)
   https://git-scm.com/download/mac
   https://git-scm.com/download/win

2. Create a free GitHub account using https://github.com/

3. Create a public new repository called mod1-labs (or any name you prefer).
4. Check Add a README file so you may include your own comments.
5. Select Create repository.
6. Copy the address of your repository.

7. Start a new Terminal session and navigate to the \labs folder.
8. Type: git clone https://github.com/<your login name>/mod1-labs.git
   Note: You only need to follow the above steps once for the entire course.

9. To save all the files in the \labs folder each time you complete a lab, type these commands.

```
   git add .
   git commit -m "lab xx completed"
   git push
```

10. Now, refresh your browser to view your lab files on GitHub.

** End **
