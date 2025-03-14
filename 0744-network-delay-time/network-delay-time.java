class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build matrix
        int[][] matrix = new int[n][n];
        for(int[] r: matrix) Arrays.fill(r, Integer.MAX_VALUE);
        for(int[] t: times){
            matrix[t[0]-1][t[1]-1] = t[2];
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(k-1);
        dist[k-1] = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){

                int curr = q.poll();
                for(int j=0;j<n;j++){
                    if(matrix[curr][j]!=Integer.MAX_VALUE && dist[curr] + matrix[curr][j] < dist[j]){ 
                        dist[j] = dist[curr] + matrix[curr][j];
                        q.add(j);
                    }
                }

            }
        }
        int time = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            time = Math.max(time,dist[i]);

        }

        return time;

    }
}