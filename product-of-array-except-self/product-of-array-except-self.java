class Solution {
    public int[] productExceptSelf(int[] nums) {
            // nums = [1,2,3,4]
    //left-to-right = [1,2,6,24]
    //right-to-left = [24,24,12,4]

    int[] l_to_r = new int[nums.length];
    int[] r_to_l = new int[nums.length];
    int[] answer = new int[nums.length]; 

    int curr1= 1 , curr2=1 ;

    for(int i = 0 ; i<l_to_r.length ; i++ ){
        curr1 *= nums[i];
        l_to_r[i] = curr1;
    }
    for(int i = r_to_l.length-1 ; i >= 0 ; i-- ){
        curr2 *= nums[i];
        r_to_l[i] = curr2;
    }

    for(int i = 0 ; i<answer.length ; i++ ){
        int left = 1 , right =1;
        if(i-1 >= 0)
            left =l_to_r[i-1];
        if(i+1 <= answer.length-1)
            right = r_to_l[i+1];
        answer[i] = left * right;
    }
    return answer;


    }
}