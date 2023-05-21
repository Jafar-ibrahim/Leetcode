class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n:arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Set<Integer> freq =  new HashSet<>(map.values());
        return(freq.size() == map.values().size()); 
        
    }
}