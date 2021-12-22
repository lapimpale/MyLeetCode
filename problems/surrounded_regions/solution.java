class Solution {
    public void solve(char[][] board) {
          int rows = board.length;
    int colms = board[0].length;
    
    for(int x = 0; x < rows ; x++){
        for(int y = 0; y < colms; y++ ){
            
            if( x == 0 || x == rows-1 || y== colms-1 || y==0){
                
                if(board[x][y] == 'O'){
                    
                    dfs(board,  x,  y,  rows,  colms);
                }
                
            }
            
        }
    }
    
    for(int x = 0; x < rows ; x++){
        for(int y = 0; y < colms; y++ ){
            
            
                
                if(board[x][y] == 'D'){
                    
                    board[x][y] = 'O';
                        
                }else{
                    
                    board[x][y] = 'X';
                }
                
           
            
        }
    }
    
}

public void dfs(char[][] board, int x, int y, int rows, int colms){
    
    if(x < 0 || y < 0 || x > rows-1 || y > colms-1 ){
        
        return;
    }
    
    //System.out.println("x= "+ x+" y= "+y);
    //box is already discovered
    if(board[x][y]!='O'){
        
        return;
    }
    
    // box is just discovered
    board[x][y] = 'D';
    
    dfs(board, x-1, y, rows, colms);
    dfs(board, x+1, y, rows, colms);
    dfs(board, x, y-1, rows, colms);
    dfs(board, x, y+1, rows, colms);
    
    
        
    }
}