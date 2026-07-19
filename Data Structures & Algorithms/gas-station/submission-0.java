class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null) return -1;

        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int remainTank = 0;
            int start = i;
            int cur = i;
            while (cur < start + n) {
                int c = cost[cur % n];
                int g = gas[cur % n];
                remainTank = remainTank + g;
                if (remainTank < c) break;;
                remainTank = remainTank - c;
                cur++;
            }
            if (cur == start + n) {
                return start;
            } 
        }
        return -1;
    }
}
