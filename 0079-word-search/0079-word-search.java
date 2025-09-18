class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backTrack(i,j,board,word,0))
                  return true;
            }
        }
       return false;
    }

    public boolean backTrack(int i,int j,char[][] board,String word,int idx){
        if(idx==word.length())
          return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length 
           || board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#'; 
        for(int[] d: dir){
            int nR = d[0] +i;
            int nC = d[1] + j;
            
            if(backTrack(nR,nC,board,word,idx+1)){
                 board[i][j] = temp;
                 return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}