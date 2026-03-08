interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return normalized.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.checkPalindrome(str);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1 for Stack, 2 for Deque");
        int choice = sc.nextInt();

        PalindromeChecker checker;
        if (choice == 1) {
            checker = new PalindromeChecker(new StackStrategy());
        } else {
            checker = new PalindromeChecker(new DequeStrategy());
        }

        if (checker.check(input)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }
    }
}
