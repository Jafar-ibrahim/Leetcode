class Solution {
    public int lengthOfLongestSubstring(String s) {
     Map<Character,Integer> map = new HashMap<>();
        int answer=0,curr=0 , start=0,end =0;
     for(int i = 0 ; i<s.length() ;){
         char c = s.charAt(i);
         if(map.get(c) == null ){
           map.put(c,1);
            curr++;
            end++;
             i++;
            
         }else if(map.get(c) == 1 ){
             answer = Math.max(answer,curr);
             while(s.charAt(start) != s.charAt(end)){
                 map.put(s.charAt(start),null);
                 start++;
                 curr--;
             }
             map.put(s.charAt(start),null);
                 start++;
                 curr--;
         }
     }
     answer = Math.max(answer,curr);
     return answer;   
    }
}