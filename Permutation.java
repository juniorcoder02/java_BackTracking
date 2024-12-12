public class Permutation {

    /**
     * Generates and prints all permutations of the given string using recursion.
     *
     * @param str The input string.
     * @param ans The current permutation being built.
     * 
     * Time Complexity: O(n * n!), where n is the length of the string.
     * Space Complexity: O(n), due to recursion stack.
     */
    public static void findPermutation(String str, String ans) {
        // Base case: If the input string is empty, print the permutation.
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursive case: Explore all possible characters for the current position.
        for (int i = 0; i < str.length(); i++) {
            // Pick the current character.
            char curr = str.charAt(i);

            // Remove the picked character from the input string.
            String NewStr = str.substring(0, i) + str.substring(i + 1);

            // Recursively find permutations for the remaining characters.
            findPermutation(NewStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        // Input string for which permutations are to be generated.
        String str = "abc";

        // Start the recursive process with an empty answer string.
        findPermutation(str, "");
    }
}
