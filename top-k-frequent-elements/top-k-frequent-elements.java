class Solution {
    public  int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>(nums.length+1);
        List<Integer> answer = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length+1;i++){
            bucket.add(new ArrayList<>());
        }

        for(int n: nums){
            map.put(n , map.getOrDefault(n,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            bucket.get(freq).add(entry.getKey());
        }
        int counter = bucket.size()-1;
        while(counter > 0 && k > 0){
            List<Integer> curr = bucket.get(counter);
            if(!curr.isEmpty()){
                for (int n :curr){
                    answer.add(n);
                     k--;
                }
               
            }
            counter--;
        }


        return answer.stream().mapToInt(i->i).toArray();
    }
}