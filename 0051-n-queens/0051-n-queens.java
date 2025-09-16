class Solution {
    List<List<String>>  res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
          Arrays.fill(board[i],'.');
        }
        backTrack(0,board,n);
        return res;
    }

    public void backTrack(int row,char[][] board,int n){
      if(n== row){
        res.add(construct(board));
        return;
      }
      for(int col=0;col<n;col++){
        if(isSafe(board,row,col,n)){
          board[row][col] = 'Q';
          backTrack(row+1,board,n);
          board[row][col] = '.';
        }
      }
    }

    public boolean isSafe(char[][] board,int row,int col,int n){
        //upper column 
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
       // left upper diagonal
        for(int i = row-1,j=col-1 ;i>=0 && j>=0 ; i--,j--){
             if(board[i][j]=='Q') return false;
        }

        // right upper diagonal
        for(int i = row-1,j=col+1 ;i>=0 && j<n ; i--,j++){
             if(board[i][j]=='Q') return false;
        }
        return true;
    }

    public List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] ch: board){
            result.add(new String(ch));
        }
        return result;
    }
}