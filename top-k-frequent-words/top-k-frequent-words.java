class Solution {
    
    public static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> max_heap =
                new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
                    public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                        if(a.getValue()==b.getValue())
                            return a.getKey().compareTo(b.getKey());
                        else
                            return b.getValue()-a.getValue();
                    }
                });
        Map<String,Integer> map = new HashMap<>();
        for (String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        max_heap.addAll(map.entrySet());
        List<String> answer = new ArrayList<>();
        for (int i=0 ; i<k ;i++){
            answer.add(max_heap.poll().getKey());
        }

        return answer;
    }
        
    }