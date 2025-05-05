
class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;  // If the array is empty, return 0
        }

        int i = 0;  // Pointer for the last unique element

        // Iterate through the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element, move the pointer i forward and update the array
            if (nums[j] != nums[i]) {
                i++;  // Move the pointer for unique elements
                nums[i] = nums[j];  // Update the array with the new unique element
            }
        }

        // The number of unique elements is i + 1 (because i is an index)
        return i + 1;
    }
}
