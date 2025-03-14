class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] matrix = new int[n][n];
        for(int[] r: matrix) Arrays.fill(r,Integer.MAX_VALUE);

        for(int[] f: flights){
            matrix[f[0]][f[1]] = f[2];
        }

        int[] og = new int[n];
        Arrays.fill(og, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        og[src] = 0;

        while(!q.isEmpty() && k>-1){
            k--;
            int size = q.size();
            int[] dist = og.clone();
            for(int j=0;j<size;j++){
                int curr = q.poll();
                for(int i=0;i<n;i++){

                    if(matrix[curr][i]!=Integer.MAX_VALUE && dist[curr] + matrix[curr][i] < og[i]){
                        
                        og[i] = dist[curr] + matrix[curr][i];
                        q.add(i);

                    }

                }
            }

        }

        return og[dst]==Integer.MAX_VALUE ? -1 : og[dst];

    }
}