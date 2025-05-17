import java.util.Arrays;

class Solution {

    /**
     * Sorts an array containing 0s, 1s, and 2s in-place.
     * 0 represents red, 1 represents white, and 2 represents blue.
     * The final order will be red, white, and then blue.
     * This implementation uses the Dutch National Flag algorithm.
     *
     * @param nums The input array of integers (0, 1, or 2).
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return; // Handle empty or null arrays
        }

        int low = 0;          // Pointer for the end of the 0s section
        int mid = 0;          // Pointer for the current element being processed
        int high = nums.length - 1; // Pointer for the start of the 2s section

        // Iterate while the mid pointer is less than or equal to the high pointer
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: // Element is 0 (red)
                    // Swap the element at mid with the element at low
                    swap(nums, low, mid);
                    // Increment both low and mid pointers
                    low++;
                    mid++;
                    break;
                case 1: // Element is 1 (white)
                    // Element is in its correct relative position, so just move mid pointer
                    mid++;
                    break;
                case 2: // Element is 2 (blue)
                    // Swap the element at mid with the element at high
                    swap(nums, mid, high);
                    // Decrement the high pointer (the swapped element at mid needs to be re-evaluated)
                    high--;
                    break;
                default:
                    // Optional: Handle unexpected values if the input constraints allow them
                    // For this problem, we assume only 0, 1, 2 are present.
                    // If other values could exist, you might throw an exception or handle them differently.
                    mid++; // Or some other error handling
                    break;
            }
        }
    }

    /**
     * Helper function to swap two elements in an array.
     *
     * @param nums The array.
     * @param i    The index of the first element.
     * @param j    The index of the second element.
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sorter = new Solution();

        // Test case 1
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Original array 1: " + Arrays.toString(nums1));
        sorter.sortColors(nums1);
        System.out.println("Sorted array 1:   " + Arrays.toString(nums1)); // Expected: [0, 0, 1, 1, 2, 2]

        // Test case 2
        int[] nums2 = {2, 0, 1};
        System.out.println("Original array 2: " + Arrays.toString(nums2));
        sorter.sortColors(nums2);
        System.out.println("Sorted array 2:   " + Arrays.toString(nums2)); // Expected: [0, 1, 2]

        // Test case 3: Already sorted
        int[] nums3 = {0, 0, 1, 1, 2, 2};
        System.out.println("Original array 3: " + Arrays.toString(nums3));
        sorter.sortColors(nums3);
        System.out.println("Sorted array 3:   " + Arrays.toString(nums3)); // Expected: [0, 0, 1, 1, 2, 2]

        // Test case 4: All same elements
        int[] nums4 = {1, 1, 1, 1};
        System.out.println("Original array 4: " + Arrays.toString(nums4));
        sorter.sortColors(nums4);
        System.out.println("Sorted array 4:   " + Arrays.toString(nums4)); // Expected: [1, 1, 1, 1]

        int[] nums5 = {0,0,0};
        System.out.println("Original array 5: " + Arrays.toString(nums5));
        sorter.sortColors(nums5);
        System.out.println("Sorted array 5:   " + Arrays.toString(nums5)); // Expected: [0,0,0]

        int[] nums6 = {2,2,2};
        System.out.println("Original array 6: " + Arrays.toString(nums6));
        sorter.sortColors(nums6);
        System.out.println("Sorted array 6:   " + Arrays.toString(nums6)); // Expected: [2,2,2]

        // Test case 7: Empty array
        int[] nums7 = {};
        System.out.println("Original array 7: " + Arrays.toString(nums7));
        sorter.sortColors(nums7);
        System.out.println("Sorted array 7:   " + Arrays.toString(nums7)); // Expected: []

        // Test case 8: Single element
        int[] nums8 = {1};
        System.out.println("Original array 8: " + Arrays.toString(nums8));
        sorter.sortColors(nums8);
        System.out.println("Sorted array 8:   " + Arrays.toString(nums8)); // Expected: [1]
    }
}
