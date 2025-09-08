package lab01b;

import java.util.Scanner;

class Program{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter your mark:");
        int mark=scanner.nextInt();
        scanner.close();
        if(mark<1 || mark>100){
            System.err.println("Error: marks must be between 1..100 ");
        }else if(mark<50){
            System.out.println("Fail");
        }else if(mark>=50 && mark<=60){
            System.out.println("Pass");
        }else if(mark>=61 && mark<=70){
            System.out.println("Merit");
        }else{
            System.out.println("Distinction");
        }
    }
}