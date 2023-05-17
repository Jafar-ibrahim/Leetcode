class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] answer = new int[nums1.length];
        //int max = -1;
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            int index = map.get(nums1[i]);
            for(int j=index+1 ;j<nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    answer[i] = nums2[j];
                    break;
                    }
            }
            if(answer[i] == 0) answer[i]=-1;  
        }
        return answer;
    }
}