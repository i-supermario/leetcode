class Solution {
    public int islandPerimeter(int[][] grid) {
        
        // grid traversal
        // traverse all 4 directions, if cant return 1 for each side
        // tc of visited

        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    return traverse(i,j,grid,new boolean[m][n]);
                }
            }
        }

        return 0;


    }

    int traverse(int i, int j, int[][] grid, boolean[][] visited){

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        visited[i][j] = true;
        int perimeter = 0;
        for(int[] d: directions){

            int x = i + d[0];
            int y = j + d[1];

            if( x >=0 && x < grid.length && y >= 0 && y < grid[0].length){

                if(!visited[x][y]){
                    if(grid[x][y] == 0) perimeter += 1;
                    else perimeter += traverse(x,y, grid, visited);
                }

            }
            else perimeter += 1;

        }

        return perimeter;

    }
}