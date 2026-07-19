class Solution {
    int[] arr;
    public int[] findRedundantConnection(int[][] edges) {
        arr = new int[edges.length+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] cur = edges[i];
            if (!union(cur[0],cur[1])) {
                return cur;
            }
         System.out.println(arr[i]);


        }
        return new int[]{};
    }
    //  0 1 2 3 4
    // [0 1 2 3 4]

    public int find(int x) {
        if (arr[x] == x) {
            return arr[x];
        }
        return find(arr[x]);
    }

    public boolean union(int x, int y) {
                            System.out.println(x + "/" + y);

        int xRoot = find(x);
        int yRoot = find(y);
                    
        if (xRoot == yRoot) {
            return false;
        }
         arr[xRoot] = yRoot;
        return true;
    }
}
