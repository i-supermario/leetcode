class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int[][] directions = new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(board[curr[0]][curr[1]] == 'M') board[curr[0]][curr[1]] = 'X';
            else{
                int mineCount = 0;
                for(int[] d: directions){
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if(x >= 0 && x < board.length && y >= 0 && y < board[0].length ){
                        if(board[x][y] == 'M' || board[x][y] == 'X') mineCount++;
                    }
                    
                }
                if(mineCount > 0) board[curr[0]][curr[1]] = (char)('0' + mineCount);
                else{
                    board[curr[0]][curr[1]] = 'B';
                    for(int[] d: directions){
                        int x = curr[0] + d[0];
                        int y = curr[1] + d[1];

                        if(x >= 0 && x < board.length && y >= 0 && y < board[0].length ){
                            if(board[x][y] == 'E'){
                                board[x][y] = 'B';
                                q.add(new int[]{x,y});
                            }
                        }
                        
                    }
                }
            }

            

        }

        return board;



    }

    
}
