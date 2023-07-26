class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int answer= 0 ;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        int last = intervals[0][1];
        for(int i=1 ; i< intervals.length  ; i++){
            if( intervals[i][0] < last ) {
                answer++;
            }else
                last = intervals[i][1];
        }
        return answer;
    }
}