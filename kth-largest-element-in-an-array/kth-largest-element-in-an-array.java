class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(y.compareTo(x)));
      for(int n:nums){
          pq.add(n);
      }
      int counter =k; 
      while(counter>1){
        pq.poll();
        --counter;
      }
      return pq.poll();  
    }
}