class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] i : intervals)
            if (!merged.isEmpty() && merged.getLast()[1] >= i[0])
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            else merged.add(i);
        return merged.toArray(new int[0][]);
    }
}