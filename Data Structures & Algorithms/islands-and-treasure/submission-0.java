
class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int row = grid.length;
        int col = grid[0].length;
        
        // BFS를 위한 큐 선언 (int[] 배열로 [r, c] 좌표를 담습니다)
        Queue<int[]> queue = new LinkedList<>();
        
        // 1. 맵을 전체 순회하면서 '모든 보물(0)'의 위치를 먼저 찾아서 큐에 넣습니다.
        for (int i = 0; i < row; i++) {
           for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
           } 
        }
        
        // 2. 큐가 빌 때까지 파도를 넓혀 나갑니다 (BFS 출발!)
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 범위 체크
                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    // 💡 [핵심 조건] 다음 칸의 거리가 (현재 칸의 거리 + 1)보다 크다면?
                    // 더 짧은 거리로 갱신할 수 있다는 뜻이므로 값을 바꾸고 큐에 넣습니다!
                    // 이 조건 덕분에 -1(벽)이나 이미 최단거리로 세팅된 0(보물)은 자연스럽게 패스됩니다.
                    if (grid[nr][nc] > grid[r][c] + 1) {
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[]{nr, nc}); // 다음 탐색을 위해 큐에 추가
                    }
                }
            }
        }
    }
}