class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq


        boolean[] visited = new boolean[n+1];

        int[][] totalTime = new int[n+1][];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));


        for (int i = 1; i <= n ; i++){
                totalTime[i] = new int[]{Integer.MAX_VALUE,i};
        }
        totalTime[k][0] = 0;

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


                    totalTime[neighbor][0] = newTime;
                    pq.add(new int[]{newTime,neighbor});
                }
            }

        return n == 0 ? answer : -1;
    }
}