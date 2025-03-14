class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m = points.length;
        int[][] matrix = new int[m][m];

        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                matrix[i][j] = Math.abs(points[i][0] - points[j][0] ) + Math.abs(points[i][1] - points[j][1]);
                matrix[j][i] = matrix[i][j];
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        q.add(new int[]{0,0});
        int total = 0;

        while(!q.isEmpty() && visited.size()!=m){
            int[] curr = q.poll();
            if(visited.contains(curr[0])) continue;
            visited.add(curr[0]);
            total += curr[1];
            for(int i=0;i<m;i++){
                if(!visited.contains(i)){
                    q.add(new int[]{i, matrix[curr[0]][i]});
                }
            }
        }


        return total;

    }
}