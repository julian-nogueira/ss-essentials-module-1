
package com.ss.jb.Assignment1;

/**
 * The Assignment1 class contains a separate function for each pattern. The
 * main function invokes all four pattern functions.
 */
public class Assignment1{
    static void pattern1(){
        System.out.println("1)");
        for(int i = 1; i < 5; i++){
            System.out.println("*".repeat(i));
        }
        System.out.println(".".repeat(9));
    }

    static void pattern2(){
        System.out.println("2)");
        System.out.println(".".repeat(10));
        for(int i = 4; i > 0; i--){
            System.out.println("*".repeat(i));
        }
    }

    static void pattern3(){
        System.out.println("3)");
        String padding;
        String content;
        int count = 1;
        for(int i = 5; i > 1; i--){
            padding = " ".repeat(i);
            content = "*".repeat(count);
            System.out.println(padding + content + padding);
            count += 2;
        }
        System.out.println(".".repeat(11));
    }

    static void pattern4(){
        System.out.println("4)");
        System.out.println(".".repeat(12));
        String padding;
        String content;
        int count = 7;
        for(int i = 2; i < 6; i++){
            padding = " ".repeat(i);
            content = "*".repeat(count);
            System.out.println(padding + content + padding);
            count -= 2;
        }
    }

    public static void main(String[] args){
        pattern1();
        pattern2();
        pattern3();
        pattern4();
    }
}

