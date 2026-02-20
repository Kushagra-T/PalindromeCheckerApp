import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("Input text:");
        String word = sc.nextLine();
        boolean isPalindrome = true;

        char[] charArray = word.toCharArray();

        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            if (charArray[start] != charArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }


        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}