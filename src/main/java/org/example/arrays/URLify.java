package main.java.org.example.arrays;

public class URLify {

    public static void main(String[] args0) {

        //String input = "Mr John Smith    ";
        String input = "HELLO CRUEL CRUEL WORLD      ";

        String urlIfied = urlIfy(input);
        System.out.print(urlIfied);
    }

    public static String urlIfy(String input) {
        int spaces = countSpaces(input);
        int remainingInsertions = spaces / 3;
        if(spaces == 0 || remainingInsertions == 0){
            //no insertions needed
            return input;
        }
        char[] charArray = input.toCharArray();
        int rightMostSpaceIndex = charArray.length - 1;

        //indicates if we have already shifted a word to the right
        boolean shiftedAWord = false;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (Character.isSpaceChar(charArray[i]) && shiftedAWord){
                charArray[rightMostSpaceIndex] = '%';
                charArray[rightMostSpaceIndex-1] = '0';
                charArray[rightMostSpaceIndex-2] = '6';
                remainingInsertions--;
                if(remainingInsertions == 0){
                    break;
                }
                rightMostSpaceIndex = rightMostSpaceIndex-3;
                //continue working our way leftward
                i = rightMostSpaceIndex+1; //loop will reduce i by one
                //switch back to false
                shiftedAWord = false;
            }
            else if(!Character.isSpaceChar(charArray[i])){
                //move to rightmost space index
                charArray[rightMostSpaceIndex] = charArray[i];
                charArray[i] = ' ';
                rightMostSpaceIndex--;
                shiftedAWord = true;
            }
        }

        return new String(charArray);
    }

    private static int countSpaces(String input) {
        int count = 0;
        //for (Character ch : Lists.charactersOf(input)) {
        for(Character ch: input.toCharArray()){
            if (Character.isSpaceChar(ch)) {
                count++;
            }
        }
        return count;
    }

}
