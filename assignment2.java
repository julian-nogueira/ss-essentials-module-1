
package com.ss.jb.Assignment2;

import java.util.Scanner;
import java.lang.Math;

/**
 * The Assignment2 class generates a random number between 1 and 100. A user is
 * prompted to guess what the number is. If the guess is within 10 units of the
 * answer, the user wins the game. Otherwise, the user has a total of five
 * tries to guess the number before the program terminates. Input is validated,
 * and a guess only counts if it was a valid guess.
 */
public class Assignment2{
    /**
     * This function calls on the remaining functions to generate the random
     * number, prompt the user to make a guess, as well as validate input.
     */
    static void playGuessingGame(){
        int answer = generateRandomNumber(100);
        int guess;
        int guessCount = 0;
        boolean correctGuess = false;
        String answerString = String.valueOf(answer);

        // System.out.println(answer); // Uncomment to display the random int.
        System.out.println("\nGuess an integer between 1-100. If the guess is within 10 units of the integer, you win! You have five guesses.\n");
        while(correctGuess == false && guessCount < 5){
            guessCount++;
            System.out.println("Guess #" + String.valueOf(guessCount));
            guess = promptUserForGuess();
            correctGuess = compareGuessToAnswer(answer, guess);
            if(correctGuess){
                System.out.println("\nCongratulations! The number was " + answerString + ".\n");
            }else if(!correctGuess && guessCount == 5){
                System.out.println("\nSorry! You did not guess with five tries. The number was " + answerString + ".\n");
            }else{
                System.out.println("\nKeep guessing!\n");
            }
        }
    }

    static int generateRandomNumber(int upperbound){
        int randomNumber = (int)(Math.random() * upperbound) + 1;
        return randomNumber;
    }

    static int promptUserForGuess(){
        Scanner scanner = new Scanner(System.in);
        String guess;
        String errorMessage = "You did not enter a valid integer.\n";
        boolean enteredValidInt = false;
        int validInt = -1;

        while(!enteredValidInt){
            System.out.println("Enter an integer.");
            guess = scanner.nextLine();
            try{
                validInt = Integer.parseInt(guess);
                if(validInt >= 1 && validInt <= 100){
                    enteredValidInt = true;
                }else{
                    System.out.println(errorMessage);
                }
            }catch(NumberFormatException e){
                System.out.println(errorMessage);
            }
        }

        return validInt;
    }

    static boolean compareGuessToAnswer(int answer, int guess){
        boolean result = false;
        int lowerBoundary = answer - 10;
        int upperBoundary = answer + 10;

        if(answer < 11){
            lowerBoundary = 1; // Edge case: answer is less than 11.
        }else if(answer > 90){
            upperBoundary = 100; // Edge case: answer is greater than 90.
        }

        result = guess >= lowerBoundary && guess <= upperBoundary;

        return result;
    }

    public static void main(String[] args){
        playGuessingGame();
    }
}
