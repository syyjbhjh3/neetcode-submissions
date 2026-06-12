class Solution {

    private boolean[][] visited;
    private int cnt = 0;

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        visited = new boolean[grid.length][grid[0].length];

        for (int row=0; row<grid.length; row++) {
            for (int cell=0; cell<grid[0].length; cell++) {
                if(grid[row][cell] == '1' && !visited[row][cell]) {
                    cnt++;
                    dfs(row, cell, grid);   
                }
            }
        }
        return cnt;
    }

    private void dfs(int row, int cell, char[][] grid) {
        visited[row][cell] = true;

        for (int i=0; i<4; i++) {
            int nr = row + dr[i];
            int nc = cell + dc[i];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (grid[nr][nc] == '1' && !visited[nr][nc]) {
                    dfs(nr, nc, grid);
                }
            }
        }
    }
}
