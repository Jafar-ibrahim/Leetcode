class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1 , answer = 0;
        while(right > left){
            answer = Math.max(answer , Math.min(height[right],height[left])*(right-left));
            if(height[left] > height[right])
                right--;
            else
                left++;
        }
        return answer;
    }
}