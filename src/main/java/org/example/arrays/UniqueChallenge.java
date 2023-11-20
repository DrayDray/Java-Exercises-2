package main.java.org.example.arrays;

import java.util.HashSet;
import java.util.Scanner;


//**
// Part I: Implement an algorithm to determine if a string has all unique characters.
// Part II: What if you cannot use additional data structures?
public class UniqueChallenge {

    public static void main(String[] args) {
        String word = inputWord();

        validate(word);

        if (isAllCharsUnique(word)) {
            System.out.println("All characters in the provided string are unique.");
        } else {
            System.out.println("Not all characters are unique.");
        }

    }

    public static String inputWord(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter word:");

        return myObj.nextLine();  // Read user input
    }

    private static boolean isAllCharsUnique(String word) throws IllegalArgumentException {
        char[] charArray = word.toCharArray();
        //create our hashset
        HashSet<Character> charHashSet = new HashSet<>();

        //iterate through our word array
        for(int i = 0; i < charArray.length; i++){
            Character charachter = charArray[i];
            //if hashset already contains this string - it is a duplicate and we can return false
            if(charHashSet.contains(charachter)){
                return false;
            }
            //otherwise this is a new char - store it in our hashset
            else {
                charHashSet.add(charachter);
            }
        }
        //if we made it here there are no duplicates
        return true;
    }

    private static void validate(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Invalid: Word is null.");
        }
    }
}
