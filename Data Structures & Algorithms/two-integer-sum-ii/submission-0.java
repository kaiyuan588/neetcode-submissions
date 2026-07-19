class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[]{};

        int l = 0;
        int r = numbers.length-1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[] {l+1, r+1};
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {};
    }
}
