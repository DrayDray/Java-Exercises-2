package main.java.org.example.recursion;

public class Fibbonacci {

    public static void main(String[] args) {
        Integer result = doFib(3);
        System.out.println(result);
    }

    public static int doFib(Integer elements) {
        if (elements == 0)
            return 0;
        if (elements == 1)
            return 1;

        return doFib(elements - 1, 0, 1);
    }

    public static int doFib(Integer element, Integer a, Integer b) {
        int sum = a + b;
        a = b;
        b = sum;
        element = element - 1;
        if (element == 0) {
            return sum;
        } else {
            return doFib(element, a, b);
        }
    }
}
