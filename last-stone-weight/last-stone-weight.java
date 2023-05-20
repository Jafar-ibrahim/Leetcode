class Solution {
    public int lastStoneWeight(int[] stones) {
         
        PriorityQueue<Integer> max_heap  = new PriorityQueue<>(Collections.reverseOrder());
        for(int n:stones){
            max_heap.add(n);
        }
        while(max_heap.size() > 1){
            int y = max_heap.poll();
            int x = max_heap.poll();
            if(y>x) max_heap.offer(y-x);
        }
        if(max_heap.isEmpty())
            return 0;
        else
            return max_heap.poll();
    }
}