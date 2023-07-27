class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        ArrayList<int[]> answer = new ArrayList<>();
        int length=0;
        int currEnd = intervals[0][1];
        int currStart = intervals[0][0];
        for(int i=1 ; i< intervals.length  ; i++){
            if( intervals[i][0] > currEnd) {
                answer.add(new int[]{currStart,currEnd});
                currStart = intervals[i][0];
                length++;
            }
            currEnd = Math.max(currEnd,intervals[i][1]);
        }
            answer.add(new int[]{currStart,currEnd});
            return answer.toArray(new int[length][]);
    }
}