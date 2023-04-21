class Solution {
    public int findKthLargest(int[] nums, int k) {
       if(nums.length == 1 ) return nums[0];
       
    int pivot = nums.length-1 , pointer = 0 ;
    while(pointer <= pivot){
        for(int i=pointer ; i<pivot ; i++){
            if(nums[i] <= nums[pivot]){
                int temp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = temp;
                pointer++;
            }
        }
        int temp = nums[pointer];
        nums[pointer] = nums[pivot];
        nums[pivot] = temp;
        if(pointer == nums.length-k) return nums[pointer];
        else if(pointer > nums.length-k){
            pivot = pointer - 1;
            pointer = 0;
        }else{
            pointer +=1;
        }
    }
    return pointer;
    }
}