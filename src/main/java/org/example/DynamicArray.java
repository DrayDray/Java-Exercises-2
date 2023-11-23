package org.example;

public class DynamicArray {

    private int[] myArray;

    private int index;

    //instantiation
    public DynamicArray() {
        //instantiate with size of 1
        this.myArray = new int[1];
        this.index = 0;
    }

    public void add(int value) {
        //if there is space in the array
        if (index < myArray.length) {
            //add item to the array
            myArray[index] = value;
            index++;
        } else {
            //double the size of the array
            int doubleSize = myArray.length * 2;
            int[] newArray = new int[doubleSize];

            //copy all of the elements of myArray into newArray
            for (int i = 0; i < myArray.length; i++) {
                newArray[i] = myArray[i];
            }

            //set myArray equals to the newArray
            this.myArray = newArray;

            //and now add the value
            myArray[index] = value;
            index++;
        }
    }

    //remove
    public void remove(int position) {
        //if the position is greater than our index or size of our array; do nothing
        if (position > index || position > myArray.length) {
            return;
        }
        //start at position and shift everything to the left
        for (int i = position; i < myArray.length; i++) {
            //for last position always delete value
            if (i == myArray.length - 1) {
                myArray[i] = 0;
            } else {
                //shift one to the left
                myArray[i] = myArray[i + 1];
            }
        }
    }

    public int[] getMyArray() {
        return myArray;
    }

    public static void main(String[] args) {
        //random tests
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);
        dynamicArray.add(40);
        dynamicArray.add(50);

        dynamicArray.remove(2);
        dynamicArray.remove(0);


        System.out.println(new StringBuilder().append("Size: ").append(dynamicArray.getMyArray().length));
        System.out.println("Values:");
        for (int i = 0; i < dynamicArray.getMyArray().length; i++) {
            int value = dynamicArray.getMyArray()[i];
            System.out.println(new StringBuilder().append(value).append(", "));
        }

    }

}


