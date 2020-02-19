/**
 * Author: Kyle Xyian Dilbeck
 * Title: Hangman.java
 * Date: 2/18/2020
 * Abstract: this program is a hangman game with hints.
 */
//import sun.text.normalizer.UCharacter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Hangman{
    
    static public void guessword(String user, int lifes){
        char[]fillIn = new char[user.length()];
        int i =0;
        while(i < user.length()){
            fillIn[i]= '-';
            if(user.charAt(i)==' '){
                fillIn[i]='#';
            }
            i++;
        }
        System.out.print("So, far your word is: ");
        System.out.println(fillIn);
        System.out.println("You have " + lifes +" incorrect guesses left.");
        int choice;
        Scanner s = new Scanner(System.in);
        ArrayList<Character> l= new ArrayList<Character>();
        int hints = 3;
        while (lifes>0){
            System.out.print("Enter a 1 for guessing or a 2 for hint: ");
            choice = s.nextInt();
            char x=' ';
            if(choice==1){
                System.out.print("Enter your guess: ");
                x = Character.toUpperCase(s.next().charAt(0));
            }
            if(choice == 2 && hints > 0){
                 for(int t=0;t<user.length();t++)
                 {
                     if(fillIn[t]=='-')
                     {
                         x = user.charAt(t);
                         hints--;
                         lifes--;
                         if(hints==1){
                             System.out.println("There are no more hints!");
                         }
                         break;
                     }
                 }
            }//end hints 
            if(l.contains(x)){
                System.out.println("Not valid input. You already guessed "+ x +".");
                continue;
            }
            l.add(x);
            if(user.contains(x+"")){
                int repeats = 0;
                boolean testicles = false;
                for(int y=0;y<user.length();y++){
                    if(user.charAt(y) == x && !testicles){
                        testicles = true;
                        fillIn[y]=x;
                        repeats ++;
                    }
                    else if(user.charAt(y) == x && testicles){
                        fillIn[y]=x;
                        repeats ++;
                    }
                }
                if(repeats > 0){
                    System.out.println("That's right! " + x+" is in the word " + repeats + " times.");
                }
            }
            else{
                System.out.println("Sorry, " + x + " isn't in the word.");
                lifes--;
            }
            if(user.equals(String.valueOf(fillIn)) || !arrayHasDash(fillIn)){
                System.out.print("Congratulations! The word was ");
                System.out.println(fillIn);
                break;
            }
            System.out.print("So, far your word is: ");
            System.out.println(fillIn);
            System.out.println("You have "+ lifes+" incorrect guesses left.");
        }
        if(lifes == 0 ){
            System.out.println("You failed. The word was " + user);
        }
    }//end guessword
    
    public boolean arrayHasDash(char [] myArray){
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] == '-'){
                return true;
            }
        }
        return false;
    }
    
    //begin main -----
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("--------- Welcome to Hangman ---------");
        System.out.print("Enter a word: ");
        String one = input.nextLine();
        String user = one.toUpperCase();
        int lifes=4;
        guessword(user,lifes);
    }//end main
    
}//end hangman class