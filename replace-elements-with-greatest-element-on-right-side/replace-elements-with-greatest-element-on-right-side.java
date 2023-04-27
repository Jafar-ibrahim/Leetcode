class Solution {
    public int[] replaceElements(int[] arr) {
        int curr_max = -1;
        for(int i = arr.length-1 ; i >=0 ; i--){
            int temp = curr_max;
            curr_max = Math.max(curr_max, arr[i]);
            arr[i] = temp;
        }
        return arr;
    }
}