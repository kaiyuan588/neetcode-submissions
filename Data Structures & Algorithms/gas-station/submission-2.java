class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0;
        for (int g: gas) {
            gasTotal += g;
        }
        int costTotal = 0;
        for (int c: cost) {
            costTotal += c;
        }
        if (gasTotal < costTotal) {
            return -1;
        }
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;

            if (total < 0) {
                total = 0;
                start = i+1;
            }
        }
        return start;
    }
}
