class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        boolean[] visited = new boolean[n+1];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));



        pq.add(new int[]{0,k});

        int answer = -1 ;

        while (!pq.isEmpty()){

            int[] pair = pq.poll();
            int currNode =pair[1];
            int currTime = pair[0];

            Map<Integer,Integer> neighbors = map.get(currNode);

            if(visited[currNode]) continue;
            visited[currNode] = true;
            n--;
            answer = currTime;

            if (neighbors != null)
                for (Map.Entry<Integer,Integer> entry : neighbors.entrySet() ){
                    int travelTime = entry.getValue();
                    int neighbor = entry.getKey();
                    int newTime = currTime + travelTime;
                    
                    pq.add(new int[]{newTime,neighbor});
                }
            }

        return n == 0 ? answer : -1;
    }
}