class Solution {
    class DSU{

        int[] parent;
        int count;

        DSU(int n){
            parent = new int[n];
            count = n;

            for(int i=0;i<n;i++) parent[i] = i;
        }

        int find(int u){
            if(parent[u] != u){
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        boolean union(int u,int v){
            int p1 = find(u);
            int p2 = find(v);
            if(p1 == p2) return false;
            parent[p2] = p1;
            count--;
            return true;
        }

        int noOfSets(){
            return count;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {

        int n = 0;
        for(int[] e: edges){
            n = Math.max(n, Math.max(e[0],e[1]));
        }
        
        DSU dsu = new DSU(n);
        int[] ans = new int[2];
        for(int[] e: edges){
            if(!dsu.union(e[0]-1,e[1]-1)) ans = e; 
        }

        return ans;
    }
}