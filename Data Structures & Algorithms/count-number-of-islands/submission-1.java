class Solution {
    int[] parent;
    int islands;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m*n];

        for (int i = 0; i < m*n; i++) {
            parent[i] = i;
        }
        islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                }
            }
        }

        int toUnion = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int index = i * n + j;
                    // up
                    if (i > 0 && grid[i-1][j] == '1') {
                        union(index, (i-1)*n+j);
                    }
                    // down
                    if (i < m-1 && grid[i+1][j] == '1') {
                        union(index, (i+1)*n+j);
                    }
                    // left
                    if (j > 0 && grid[i][j-1] == '1') {
                        union(index, i*n+(j-1));
                    }
                    // right
                    if (j < n-1 && grid[i][j+1] == '1') {
                        union(index, i*n+(j+1));
                    }
                }
            }
        }
        return islands;
    }
    public int findRoot(int x) {
        if (parent[x] != x) {
            return findRoot(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
            islands--;
        }
    }
}
