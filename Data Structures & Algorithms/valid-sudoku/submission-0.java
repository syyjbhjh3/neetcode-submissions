class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean answer = true;

        // 1. row Valid Check
        if (!isRowValid(board)) return false;

        // 2. cell Valid Check
        if (!isCellValid(board)) return false;

        // 3. box Valid Check
        if (!isBoxValid(board,0,0)) return false;

        return answer;
    }

    private boolean isRowValid(char[][] board) {
        for (int i=0; i<board.length; i++) {
            Set<Character> set = new HashSet<>();

            for (int j=0; j<board[i].length; j++) {
                if (!set.add(board[i][j]) && board[i][j] != '.') {
                    System.out.print(i + " " + j);
                    return false;
                } 
            }
        }
        return true;
    }

    private boolean isCellValid(char[][] board) {
        for (int i=0; i<board.length; i++) {
            Set<Character> set = new HashSet<>();

            for (int j=0; j<board[i].length; j++) {
                if (!set.add(board[j][i]) && board[j][i] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBoxValid(char[][] board, int row, int col) {
        // 1. 탈출 조건: row가 9에 도달하면 모든 박스를 다 검사한 것!
        if (row == 9) {
            return true;
        }

        // 2. 현재 (row, col) 위치에서 3x3 박스 유효성 검사 (기존 2중 포문)
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char val = board[row + i][col + j];
                if (val != '.' && !set.add(val)) {
                    return false;
                }
            }
        }

        // 3. [핵심] 다음 재귀 호출 위치 결정하기
        // 한 행의 끝(col이 6인 박스)까지 다 검사했다면 -> 다음 행의 시작(row+3, 0)으로 이동
        if (col == 6) {
            return isBoxValid(board, row + 3, 0);
        } 
        // 아직 옆에 박스가 더 남았다면 -> 오른쪽 박스(row, col+3)로 이동
        else {
            return isBoxValid(board, row, col + 3);
        }
    }
}
