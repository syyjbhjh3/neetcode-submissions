class Solution {
    private int[] dr = new int[]{-1, 1, 0, 0};
    private int[] dc = new int[]{0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(r, c, board, word, 0)) {
                        return true;
                    }
                }
            }
        }   
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c]; 
        board[r][c] = '#';   
        // 사방 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (dfs(nr, nc, board, word, index + 1)) {
                return true; 
            }
        }
        board[r][c] = temp;

        return false;
    }
}