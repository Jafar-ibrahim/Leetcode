class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Pair>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
           int a = edges[i][0], b = edges[i][1];
           lists.get(a).add(new Pair(b, succProb[i]));
           lists.get(b).add(new Pair(a, succProb[i]));
        }

        

        double[] totalProb = new double[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> -a.prob));

        totalProb[start_node] = 1.0;
        pq.add(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            double currProb = curr.prob;

            if(currNode == end_node)
                return totalProb[end_node];

            List<Pair> list = lists.get(currNode);
            for (Pair pair : list) {
                if (pair.prob * totalProb[currNode] > totalProb[pair.node]) {
                    totalProb[pair.node] = pair.prob * totalProb[currNode];
                    pq.offer(new Pair(pair.node, totalProb[pair.node]));
                }
            }
            
        }
        return 0d;
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