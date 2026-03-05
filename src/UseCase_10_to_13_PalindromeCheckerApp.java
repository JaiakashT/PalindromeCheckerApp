import java.util.*;

/* ================= UC11: OOP Service ================= */

class PalindromeChecker {

    public boolean checkPalindrome(String word) {

        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}


/* ================= UC12: Strategy Pattern ================= */

interface PalindromeStrategy {
    boolean check(String word);
}


/* Stack Strategy */

class StackStrategy implements PalindromeStrategy {

    public boolean check(String word) {

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/* Deque Strategy */

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String word) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}


/* Strategy Context */

class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String word) {
        return strategy.check(word);
    }
}



/* ================= MAIN APPLICATION ================= */

public class UseCase_10_to_13_PalindromeCheckerApp {


    /* ================= UC10 ================= */
    public static boolean checkNormalizedPalindrome(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    public static void main(String[] args) {

        String test = "Madam";

        /* ================= UC10 ================= */

        System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");

        boolean result10 = checkNormalizedPalindrome(test);

        System.out.println("Input: " + test);
        System.out.println("Palindrome: " + result10);

        System.out.println();


        /* ================= UC11 ================= */

        System.out.println("UC11: Object-Oriented Palindrome Service");

        PalindromeChecker checker = new PalindromeChecker();

        boolean result11 = checker.checkPalindrome(test.toLowerCase());

        System.out.println("Result: " + result11);

        System.out.println();


        /* ================= UC12 ================= */

        System.out.println("UC12: Strategy Pattern");

        PalindromeContext context = new PalindromeContext();

        context.setStrategy(new StackStrategy());
        System.out.println("Stack Strategy: " + context.execute(test.toLowerCase()));

        context.setStrategy(new DequeStrategy());
        System.out.println("Deque Strategy: " + context.execute(test.toLowerCase()));

        System.out.println();


        /* ================= UC13 ================= */

        System.out.println("UC13: Performance Comparison");

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        checker.checkPalindrome(test.toLowerCase());
        endTime = System.nanoTime();
        System.out.println("Basic Method Time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        new StackStrategy().check(test.toLowerCase());
        endTime = System.nanoTime();
        System.out.println("Stack Method Time: " + (endTime - startTime) + " ns");


        startTime = System.nanoTime();
        new DequeStrategy().check(test.toLowerCase());
        endTime = System.nanoTime();
        System.out.println("Deque Method Time: " + (endTime - startTime) + " ns");

    }
}