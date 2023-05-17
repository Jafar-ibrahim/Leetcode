class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int i=0;i<nums2.length;i++){
             while(!stack.empty() && nums2[i] > stack.peek()){
                 answer[map.get(stack.pop())] = nums2[i];
             }
             if(map.get(nums2[i]) != null) stack.push(nums2[i]);
        }
        while(!stack.empty()){
            answer[map.get(stack.pop())] = -1;
        }
        return answer;
    }
}