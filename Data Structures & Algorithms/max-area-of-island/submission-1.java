class Solution {

    private boolean[][] visited;
    private int max = 0;

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int currentArea = dfs(i, j, grid);
                    max = Math.max(max, currentArea);
                }
            }
        }
        return max;
    }

    private int dfs(int row, int col, int[][] grid) {
        visited[row][col] = true;
        
        int area = 1; 

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (grid[nr][nc] > 0 && !visited[nr][nc]) {
                    area += dfs(nr, nc, grid);
                }
            }
        }
        
        return area;
    }
}