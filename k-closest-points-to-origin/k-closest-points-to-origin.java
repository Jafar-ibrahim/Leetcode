class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((x,y)-> difference(distance(y),distance(x)));
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

    public static double distance(int[] point){
        return (Math.pow(Math.pow(point[0],2) + Math.pow(point[1],2) ,0.5));
    }
    public static int difference(double x , double y){
        double diff = x - y;
        if(diff > 0) return 1;
        else if(diff <0) return -1;
        else return 0;
    }
}