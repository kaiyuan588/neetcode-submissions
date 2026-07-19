class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null) return -1;

        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int start = i;
            int remainTank = 0;

            while (start < i + n) {
                int updatedIndex = start % n;
                remainTank += gas[updatedIndex];
                if (remainTank < cost[updatedIndex]) {
                    break;
                }
                remainTank -= cost[updatedIndex];
                start++;
            }
            if (start == i + n) {
                return i;
            }            
        }
        return -1;
    }
}
