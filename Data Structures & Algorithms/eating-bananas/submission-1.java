class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) return 0;
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i: piles) {
            right = Math.max(right, i);
        }
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid, h)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    public boolean canEat(int[] piles, int curSpeed, int h) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double)piles[i] / (double)curSpeed);
            if (hours > h) {
                return false;
            }
        }
        return hours <= h;
    }
}
