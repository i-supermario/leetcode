class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<m;i++){
            dfs(i,0,heights,pacific);
            dfs(i,n-1, heights, atlantic);
        }

        for(int i=0;i<n;i++){
            dfs(0,i,heights,pacific);
            dfs(m-1,i, heights, atlantic);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }

    private void dfs(int i,int j,int[][] heights, boolean[][] visited){
        int m = heights.length, n = heights[0].length;
        visited[i][j] = true;
        int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] move: moves){
            int x = i + move[0];
            int y = j + move[1];

            if((x >= 0 && x < m && y >=0 && y < n) && !visited[x][y] && heights[x][y] >= heights[i][j] ){
                dfs(x,y,heights,visited);
            }

        }
        return;

    }
}