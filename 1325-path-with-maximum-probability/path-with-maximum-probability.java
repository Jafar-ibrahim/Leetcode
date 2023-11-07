class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) lists.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
           int a = edges[i][0], b = edges[i][1];
           lists.get(a).add(new Pair(b, succProb[i]));
           lists.get(b).add(new Pair(a, succProb[i]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] probs = new double[n];
        probs[start_node] = 1.0;
        queue.offer(new Pair(start_node, 1.0));
        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            if (curPair.node == end_node) return probs[curPair.node];
            List<Pair> list = lists.get(curPair.node);
            for (Pair pair : list) {
                if (pair.prob * probs[curPair.node] > probs[pair.node]) {
                    probs[pair.node] = pair.prob * probs[curPair.node];
                    queue.offer(new Pair(pair.node, probs[pair.node]));
                }
            }
        }

        return 0;
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