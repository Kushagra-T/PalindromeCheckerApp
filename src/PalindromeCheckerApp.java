import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scanner.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue characters and push to stack
        for (char ch : input.toCharArray()) {
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;


        while (!queue.isEmpty() && !stack.isEmpty()) {
            char qChar = queue.remove();
            char sChar = stack.pop();

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Is a Palindrome? : "+isPalindrome);
    }
}