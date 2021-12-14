class Solution {
    public boolean exist(char[][] board, String word) {
      for(int i = 0; i<board.length;i++){
          for(int j = 0; j<board[0].length; j++){
              if(board[i][j] == word.charAt(0)){
                  if(dfs(board,i,j,word,0)) return true;
              }
          }
      }
        return false;
    }
    
    
    private boolean dfs(char[][] board, int i, int j, String word, int pos){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '*')return false;
        char temp = board[i][j];
        if(board[i][j] != word.charAt(pos))return false;
        if(pos == word.length() - 1)return true;
        board[i][j] = '*';
        if(dfs(board,i+1,j,word,pos+1) || dfs(board,i-1,j,word,pos+1) || dfs(board,i,j-1,word,pos+1) || dfs(board,i,j+1,word,pos+1))return true;
        board[i][j] = temp;
        return false;
}
}