class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] grid = new int[n][n];

        for(int[] r: grid) Arrays.fill(r, Integer.MAX_VALUE);

        for(int[] f: flights){
            grid[f[0]][f[1]] = f[2];
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty() && k > -1){
            int size = q.size();
            int[] temp = distance.clone();
            for(int j=0;j<size;j++){

                int curr = q.poll();
                
                for(int i=0;i<n;i++){

                    if(grid[curr][i] != Integer.MAX_VALUE && temp[curr] + grid[curr][i] < distance[i]){

                        
                        distance[i] = temp[curr] + grid[curr][i];
                        q.add(i);

                    }


                }
            }
            k--;

        }

        return distance[dst] != Integer.MAX_VALUE ? distance[dst] : -1; 

        
    }
}