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

        

        boolean[] visited = new boolean[n];
        double[] totalProb = new double[n];

        PriorityQueue<Pair<Integer,Double>> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> -a.getValue()));

        pq.add(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            //System.out.println(pq);
            Pair<Integer,Double> curr = pq.poll();
            int currNode = curr.getKey();
            double currProb = curr.getValue();

            if(currNode == end_node)
                return currProb;

            if(visited[currNode]) continue;
            visited[currNode] = true;
            Map<Integer,Double> neighbors = map.get(currNode);

            if(currProb > totalProb[currNode] && neighbors != null ){
                totalProb[currNode] = currProb;
                for(Map.Entry<Integer,Double> entry : neighbors.entrySet()){
                    int neighbor = entry.getKey();
                    double edgeProb = entry.getValue();
                    double newProb = edgeProb * currProb;
                    if(newProb > totalProb[neighbor])
                        pq.add(new Pair(neighbor,newProb));
                }
            }
        }
        return totalProb[end_node];
    }
}