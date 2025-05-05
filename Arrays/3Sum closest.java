
import java.util.*;

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array to use two-pointer technique
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize closest sum with the first possible sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;  // If we find an exact match, return it
                }

                // Update closestSum if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;  // Increase sum by moving the left pointer to the right
                } else {
                    right--;  // Decrease sum by moving the right pointer to the left
                }
            }
        }

        return closestSum;  // Return the closest sum found
    }
}
