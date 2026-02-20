import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Input: ");
        String input = scanner.nextLine();

        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < processedInput.length(); i++) {
            deque.addLast(processedInput.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is a Palindrome? : "+isPalindrome);

    }
}