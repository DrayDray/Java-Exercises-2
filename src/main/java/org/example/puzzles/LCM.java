package main.java.org.example.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the sum of all the LCM of all the subsets of numbers between 1 and N.
 */
public class LCM {

    public static void main(String[] args) {
        List<Integer> list = generateList();

        //get all the subsets within the list
        HashMap<Tuple, Long> pairToLCM = new HashMap<Tuple, Long>();

        generateAllSubsets(list, pairToLCM);
        //for testing - print all pairs first

        System.out.println("Pairs:");
        long sum = 0;
        for(Map.Entry entry: pairToLCM.entrySet()){
            pairToLCM.put((Tuple) entry.getKey(), findLCM((Tuple)entry.getKey()));
            System.out.println(((Tuple) entry.getKey()).getA() + " | : " + ((Tuple) entry.getKey()).getB() + " | LCM: " + entry.getValue());
            sum = sum + (Long) entry.getValue();
        }
        System.out.println("Sum: " + sum);


    }

    private static Long findLCM(Tuple key) {
        Long lcm = null;
        int a = key.getA();
        int b = key.getB();
        //b is always greater
        if (b % a == 0) {
            //then be is the lcm
            return Long.valueOf(b);
        }
        int multiplier = 2;
        boolean isFound = false;
        while (!isFound) {
            long result = b * multiplier;
            if (result % a == 0) {
                lcm = result;
                isFound = true;
            }
            multiplier++;
        }
        return lcm;
    }

    private static void generateAllSubsets(List<Integer> list, HashMap<Tuple, Long> pairToLCM) {
        for (int i = 0; i < list.size() - 2; i++) {
            for (int innerIndex = i + 1; innerIndex < list.size() - 1; innerIndex++) {
                int a = list.get(i);
                int b = list.get(innerIndex);
                //TODO make this a prettier external validation
                if (a != b && a > 0 && b > 0) {
                    Tuple tuple = null;
                    if (a < b) {
                        tuple = new Tuple(a, b);
                    } else {
                        tuple = new Tuple(b, a);
                    }

                    //will add lcm for each tuple later
                    pairToLCM.put(tuple, null);
                }
            }
        }
    }

    public static List<Integer> generateList() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(15);
        list.add(3);
        list.add(2);
        return list;
    }

}
