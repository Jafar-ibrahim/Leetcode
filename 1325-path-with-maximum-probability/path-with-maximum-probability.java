class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer,Map<Integer,Double>> map = new HashMap<>();

        for(int i = 0 ; i < edges.length ; i++){
            int node = edges[i][0];
            int neighbor = edges[i][1];
            double prob = succProb[i];

            map.putIfAbsent(node,new HashMap<>());
            map.putIfAbsent(neighbor,new HashMap<>());

            map.get(node).put(neighbor,prob);
            map.get(neighbor).put(node,prob);
        }

        

        double[] totalProb = new double[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> -a.prob));

        pq.add(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.prob;

            if(currNode == end_node)
                return currProb;

            Map<Integer,Double> neighbors = map.get(currNode);

            if(neighbors != null )
                
                for(Map.Entry<Integer,Double> entry : neighbors.entrySet()){
                    int neighbor = entry.getKey();
                    double edgeProb = entry.getValue();
                    double newProb = edgeProb * currProb;
                    if(newProb > totalProb[neighbor]){
                        totalProb[currNode] = currProb;
                        pq.add(new Pair(neighbor,newProb));
                    }
                }
            
        }
        return totalProb[end_node];
    }
}

class Pair{
    double prob;
    int node;
    Pair(int node, double prob) {
        this.prob = prob;
        this.node = node;
    }
}