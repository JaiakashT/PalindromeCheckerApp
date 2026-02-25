//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("===================================");
        System.out.println("        PALINDROME CHECKER APP     ");
        System.out.println("===================================");
        System.out.println("Version: 1.0");
        System.out.println("===================================");

        String word = "madam";

        // ================= UC2 =================
        if (word.equals("madam")) {
            System.out.println("UC2: Hardcoded Check -> Palindrome");
        } else {
            System.out.println("UC2: Not Palindrome");
        }

        // ================= UC3 =================
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("UC3: String Reverse -> Palindrome");
        }

        // ================= UC4 =================
        char[] arr = word.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        boolean isPalindromeArray = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindromeArray = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindromeArray) {
            System.out.println("UC4: Char Array -> Palindrome");
        }

        // ================= UC5 =================
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindromeStack = true;
        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                isPalindromeStack = false;
                break;
            }
        }

        if (isPalindromeStack) {
            System.out.println("UC5: Stack -> Palindrome");
        }

        // ================= UC7 =================
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeDeque = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeDeque = false;
                break;
            }
        }

        if (isPalindromeDeque) {
            System.out.println("UC7: Deque -> Palindrome");
        }

        System.out.println("===================================");
        System.out.println("Application Completed Successfully");
    }
}