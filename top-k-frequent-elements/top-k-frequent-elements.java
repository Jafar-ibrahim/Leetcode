class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        
        //count the frequency
        for ( int num : nums ){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // fill the bucket with (frequncey -> list) or numbers with that frequency
        for ( int key : map.keySet() ){
            int freq = map.get(key);  
            if ( bucket[freq] == null ) bucket[freq] = new ArrayList<>();
            
            bucket[freq].add(key);
        }
        
        //fill the elemnts in result array
        int[] res = new int[k];
        int j = 0;
        for ( int i = nums.length; i >= 0 && j < k; i-- ){
            if ( bucket[i] != null ){
                for ( int ele : bucket[i]) res[j++] = ele;
            }
        }
        
        return res;
    }
}