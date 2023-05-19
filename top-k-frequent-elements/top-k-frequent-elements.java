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
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        int counter = bucket.size()-1;
        while(counter > 0 && k > 0){
            if(!bucket.get(counter).isEmpty()){
                for (int n :bucket.get(counter)){
                    answer.add(n);
                     k--;
                }
               
            }
            counter--;
        }


        return answer.stream().mapToInt(i->i).toArray();
    }
}