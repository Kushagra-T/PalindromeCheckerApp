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

class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        };

        String[] names = {"StackStrategy", "DequeStrategy", "RecursiveStrategy"};

        for (int i = 0; i < strategies.length; i++) {
            long startTime = System.nanoTime();
            boolean result = strategies[i].checkPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(names[i] + ": " +
                    (result ? "Palindrome" : "Not Palindrome") +
                    " | Time taken: " + duration + " ns");
        }
    }
}
