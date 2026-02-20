import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Stack Based Palindrome Checker ===");
        System.out.print("Input: ");
        String input = scanner.nextLine();


        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < processedInput.length(); i++) {
            stack.push(processedInput.charAt(i));
        }


        String reversedString = "";

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        System.out.println("Is a Palindrome? : "+processedInput.equals(reversedString));

    }
}