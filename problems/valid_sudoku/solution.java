class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                if(board[row][col] == '.') continue;
                char num = board[row][col];
                board[row][col] = '.';
                int blkrow = (row/3)*3, blkcol = (col/3)*3;
                for(int i=0; i<9; i++){
                    if(board[row][i]==num || board[i][col]==num || board[blkrow + i/3][blkcol + i%3] == num)
                        return false;
                }
                board[row][col] = num;
            }
        }
        return true;  
    }
}