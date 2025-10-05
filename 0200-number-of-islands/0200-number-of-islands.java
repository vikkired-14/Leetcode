class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,char[][] grid){
       grid[i][j]='0';
       for(int[] d: dirs){
        int r = d[0] + i;
        int c = d[1] + j;
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]=='1')
          dfs(r,c,grid);
       }
    }
}