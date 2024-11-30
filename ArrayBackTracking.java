class ArrayBackTracking {

    /**
     * Changes array values using recursion and backtracking.
     * @param arr   The array to modify.
     * @param idx   The current index to modify.
     * @param value The value to set at the current index.
     * 
     * Time Complexity: O(n) where n is the size of the array.
     * Space Complexity: O(n) due to recursion stack.
     */
    public static void changeArr(int[] arr, int idx, int value) {
        // Base case: If index goes out of bounds, print the array and stop recursion.
        if (idx == arr.length) {
            printArr(arr);
            return;
        }

        // Modify the current index with the given value.
        arr[idx] = value;

        // Recursive call to modify the next index with an incremented value.
        changeArr(arr, idx + 1, value + 1);

        // Backtracking step: Undo the change by decreasing the value at the current index.
        arr[idx] = arr[idx] - 2;
    }

    /**
     * Prints the elements of the array.
     * @param arr The array to print.
     */
    public static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Initialize an empty array of size 5.
        int[] arr = new int[5];

        // Start modifying the array from index 0 with an initial value of 1.
        changeArr(arr, 0, 1);

        // Print the final state of the array after all recursive calls and backtracking.
        printArr(arr);
    }
}
