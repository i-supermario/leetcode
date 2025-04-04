class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(!visited[i][j] && traverse(i,j,board,visited,word,0)) return true;
            }
        }

        return false;

        
    }

    private boolean traverse(int i, int j, char[][] board, boolean[][] visited, String word, int idx){

        if(board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length() - 1) return true;
        

        visited[i][j] = true;

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] d: directions){

            int x = i + d[0];
            int y = j + d[1];

            if((x >= 0 && x<board.length && y>=0 && y<board[0].length) && !visited[x][y]){

                if(traverse(x,y,board,visited,word,idx+1)) return true;

            }

        }

        visited[i][j] = false;

        return false;


    }
}