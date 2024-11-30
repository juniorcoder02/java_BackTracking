public class Subsets {

    /**
     * Finds and prints all subsets of a given string using recursion and backtracking.
     *
     * @param str The input string.
     * @param ans The current subset being built.
     * @param idx The current index in the input string.
     * 
     * Time Complexity: O(2^n), where n is the length of the string (all possible subsets).
     * Space Complexity: O(n), due to recursion stack.
     */
    public static void findSubsets(String str, String ans, int idx) {
        // Base case: If we reach the end of the string, print the subset.
        if (idx == str.length()) {
            if (ans.length() == 0) {
                // Print "null" to represent the empty subset.
                System.out.println("null");
            } else {
                // Print the current subset.
                System.out.println(ans);
            }
            return;
        }

        // Recursive case: Explore both choices for the current character.

        // 1. Include the current character in the subset.
        findSubsets(str, ans + str.charAt(idx), idx + 1);

        // 2. Exclude the current character from the subset.
        findSubsets(str, ans, idx + 1);
    }

    public static void main(String[] args) {
        // Input string for which subsets are to be generated.
        String str = "abc";

        // Start the recursive process with an empty subset and starting index 0.
        findSubsets(str, "", 0);
    }
}
