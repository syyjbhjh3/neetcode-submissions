class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS
        // 썩은 애를 기점으로 찾으면서 올라감
            // 가장 근접한 애들을 썩게 처리하고 시간을 올림
        
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int r=0; r<row; r++){
            for (int c=0; c<col; c++){
                if (grid[r][c] == 1) {
                    // 순회시 신선한 애들 갯수를 체크함
                    fresh++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty() && fresh > 0) {
            int currentSize = queue.size();
            for (int i=0; i<currentSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dr : directions) {
                    int nr = r + dr[0];
                    int nc = c + dr[1];

                    if (nr >= 0 && nr < grid.length &&
                        nc >= 0 && nc < grid[0].length &&
                        grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }


        return fresh == 0 ? time : -1;
    }
}
