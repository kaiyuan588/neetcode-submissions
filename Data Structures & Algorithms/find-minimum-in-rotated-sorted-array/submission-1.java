class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length -1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
