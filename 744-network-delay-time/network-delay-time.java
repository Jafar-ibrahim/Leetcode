
class Pair{
    int node,dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
        
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Pair>());
        }
        
        for(int i=0;i<times.length;i++){
            adjList.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        
        int[] ans=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;
        
        pq.add(new Pair(k,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int ver=curr.node;
            int dis=curr.dist;
            
            for(Pair it:adjList.get(ver)){
                if(dis+it.dist<ans[it.node]){
                    ans[it.node]=dis+it.dist;
                    pq.add(new Pair(it.node,dis+it.dist));
                }
            }
            
        }
        
        int anss=Integer.MIN_VALUE;

        
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                return -1;
            }
            anss=Math.max(anss,ans[i]);
        }
        
        return anss;
    }
}