class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m = points.length;

        int[][] grid = new int[m][m];

        for(int i=0;i<m;i++){
            int[] p1 = points[i];
            for(int j=i+1;j<m;j++){
                int[] p2 = points[j];
                grid[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                grid[j][i] = grid[i][j];

            }
        }

        int cost = 0;
        boolean[] visited = new boolean[m];

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(visited[curr[0]]) continue;
            cost += curr[1];
            visited[curr[0]] = true;
            for(int i=0;i<m;i++){
                if(!visited[i]){
                    q.offer(new int[]{i, grid[curr[0]][i]});
                }
            }

        }

        return cost;

        
    }
}