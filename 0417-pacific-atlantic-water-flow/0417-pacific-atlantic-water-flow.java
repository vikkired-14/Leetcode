class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights==null || heights.length==0)
          return result;
          int n = heights.length;
          int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];  
        boolean[][] atlantic = new boolean[n][m];  
        //pacific top+left
        for(int i=0;i<m;i++) dfs(heights,0,i,pacific);
        for(int i=0;i<n;i++) dfs(heights,i,0,pacific);

        //atlantic right+bottom
        for(int i=0;i<m;i++) dfs(heights,n-1,i,atlantic);
        for(int i=0;i<n;i++) dfs(heights,i,m-1,atlantic);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j])
                  result.add(List.of(i,j));
            }
        }
     return result; 
    }

    public void dfs(int[][] heights,int i,int j,boolean[][] vstd){
        vstd[i][j] = true;
        for(int[] d: dir){
         int r = d[0] + i;
         int c = d[1] + j;
         if(r>=0 && r<heights.length && c>=0 && c< heights[0].length && !vstd[r][c] && heights[r][c]>=heights[i][j]){
            dfs(heights,r,c,vstd);
         }
        }
    }
}