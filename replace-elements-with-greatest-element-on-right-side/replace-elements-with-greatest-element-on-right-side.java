class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1 ; i>=0 ; i--){
            int prev=arr[i];
            arr[i] = max;
            max = Math.max(max,prev);
        }
        return arr;

    }
}