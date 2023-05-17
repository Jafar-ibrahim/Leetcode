class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        int pivot=0,end=nums.length-1;
        while(pivot <= end){
          int start = pivot;
          for(int i =pivot ; i<end ; i++){
            if(nums[i] <= nums[end]){
              swap(pivot,i,nums);
              pivot++;
            }
          }
          swap(end,pivot,nums);
          if(target == pivot) return nums[pivot];
          else if(target >  pivot){
            pivot++;
          }else{
            end=pivot-1;
            pivot=start;
          }
        }
        return -1;

    }
    public static void swap(int index1,int index2,int[] nums){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}