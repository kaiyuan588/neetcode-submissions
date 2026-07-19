class Solution {
    int[] arr;
    public int countComponents(int n, int[][] edges) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int[] e: edges) {
            union(e[0],e[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }
    public int find(int x) {
        if (arr[x] == x) {
            return arr[x];
        }
        return find(arr[x]);
    }
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        arr[xRoot] = yRoot;
    }
}
