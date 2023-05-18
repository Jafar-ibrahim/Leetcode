class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> min_heap = new PriorityQueue<>((x,y)->x.getValue().compareTo(y.getValue()));
        for(int n: nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            min_heap.offer(entry);
            if(min_heap.size() > k)
                min_heap.poll();
        }
        for(int i=0 ; i<k ; i++){
            answer[i] = min_heap.poll().getKey();
        }
        return answer;

    }
}