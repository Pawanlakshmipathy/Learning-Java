class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], increment low and mid
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                // Move mid forward if the element is 1
                mid++;
            } else {
                // Swap nums[mid] and nums[high], decrement high
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
