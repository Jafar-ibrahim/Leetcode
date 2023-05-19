class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((x,y)-> distance(y)-distance(x));
        
        for (int[] point : points) {
            max_heap.offer(point);
            if(max_heap.size() > k)
                max_heap.poll();
        }
        for(int i=0 ; i<k ; i++){
            int[] temp = max_heap.poll();
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        return answer;
    }

    public static int distance(int[] point){
        return (point[0]*point[0] + point[1] * point[1]);
    }
    
}