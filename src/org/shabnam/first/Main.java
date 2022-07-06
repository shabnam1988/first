package org.shabnam.first;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to wonderland");
        System.out.println("May i have your name?");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("hello "+ name);
        System.out.println("shall we start?");
        System.out.println("\t1. Yes ");
        System.out.println("\t2. No ");


        int beginAnswer=sc.nextInt();

        while(beginAnswer!=1){
            System.out.println("Do you want start the game?");
            System.out.println("\t1. Yes ");
            System.out.println("\t2. No ");

            beginAnswer=sc.nextInt();
        }
        Random ran=new Random();
        int x=ran.nextInt(20)+1;
        System.out.println("pleasee guess a number: ");
        int userInput=sc.nextInt();

        int timeTried=0;
        boolean hasWon=false;
        boolean shouldFinish=false;


        while (!shouldFinish){
            timeTried++;
            if(timeTried<5){
                if(userInput==x){
                    hasWon=true;
                    shouldFinish=true;
                }else if (userInput>x){
                    System.out.println("Guess lower");
                    userInput=sc.nextInt();
                }else{
                    System.out.println("Guess higher");
                    userInput=sc.nextInt();

                }
            }else{
                shouldFinish=true;
            }
        }
        if(hasWon){
            System.out.println("Cong ......your guess      "+timeTried+"guess");
        }else{
            System.out.println("game over!");
            System.out.println("The number was"+x);
        }
    }
}
