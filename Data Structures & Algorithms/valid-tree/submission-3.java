class Solution {
    int[] arr;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int[] e: edges) {
            if (!union(e[0], e[1])) {
                return false;
            }
        }
        return true;
    }

    public int find(int x) {
        if (arr[x] == x) {
            return arr[x];
        }
        return find(arr[x]);
    }

    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return false;
        }
        arr[xRoot] = yRoot;
        return true;
    }
}
