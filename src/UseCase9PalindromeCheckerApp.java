public class UseCase9PalindromeCheckerApp {

    // Recursive function
    public static boolean isPalindrome(String word, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // Compare characters
        if (word.charAt(start) != word.charAt(end))
            return false;

        // Recursive call
        return isPalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String word = "madam";

        if (isPalindrome(word, 0, word.length() - 1)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
    }
}