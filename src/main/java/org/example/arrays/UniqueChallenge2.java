package main.java.org.example.arrays;

import java.util.HashSet;
import java.util.Scanner;


//**
// Part I: Implement an algorithm to determine if a string has all unique characters.
// Part II: What if you cannot use additional data structures?
public class UniqueChallenge2 {

    public static void main(String[] args) {
        String word = inputWord();

        validate(word);

        //resolve without an additional data structure -
        if(isAllCharsUnique(word)){
            System.out.println("All characters are unique");
        }
        else{
            System.out.println("All characters are not unique.");
        }

    }

    //O(n^2)
    public static boolean isAllCharsUnique(String word){
        char[] charArray = word.toCharArray();
        for(int i = 0; i < charArray.length;i++) {
            for (int j = i+1; j < charArray.length; j++) {
                if(charArray[i] == (charArray[j])){
                    return false;
                }
            }
        }

        return true;
    }

    public static String inputWord(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter word:");

        return myObj.nextLine();  // Read user input
    }


    private static void validate(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid: Word is empty.");
        }
    }
}
