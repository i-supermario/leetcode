class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        
        int[][] temp = new int[m][n];
        for(int i=0;i<m;i++) temp[i] = board[i].clone();


        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                int liveCount = getLiveCount(i,j,temp);
                if(temp[i][j] == 1){
                    if(liveCount < 2) board[i][j] = 0;
                    else if(liveCount <= 3) board[i][j] = 1;
                    else if(liveCount > 3) board[i][j] = 0;
                }
                else{
                    if(liveCount == 3) board[i][j] = 1;
                }

            }

        }


        return;

        
    }

    private int getLiveCount(int i, int j, int[][] board){

        int[][] directions = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int count = 0;
        for(int[] d: directions){

            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 1){
                count++;
            }

        }

        return count;

    }

}