class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] nodeTimes = new int[n + 1];
        Arrays.fill(nodeTimes, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int src = time[0];
            int des = time[1];
            int tim = time[2];
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<int[]>());
            }
            graph.get(src).add(new int[]{des, tim});
        }
        nodeTimes[k] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i ++) {
                int node = queue.remove();
                List<int[]> nears = graph.get(node);
                if (nears != null) {
                    for (int[] near : nears) {
                        int des = near[0];
                        int tim = near[1];
                        if (nodeTimes[des] > nodeTimes[node] + tim) {
                            nodeTimes[des] = nodeTimes[node] + tim;
                            queue.add(des);
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0 ; i < nodeTimes.length ; i ++) {
            if (i == 0) {
                continue;
            }
            int nodeTime = nodeTimes[i];
            if (nodeTime == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, nodeTime);
        }
        return result;
    }
}