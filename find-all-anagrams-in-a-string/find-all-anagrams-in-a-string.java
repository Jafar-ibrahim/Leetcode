class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        List<Integer> answer = new ArrayList<>();

        // map characters frequencies of p
        for(int i=0;i<p.length();i++)
            map[p.charAt(i) - 'a']++;
            
        // add 1 for each present char in p to differentiate between the 0 of the chars that arent present and the 0 that occurs when consuming the frequencies of the characters
        for(int i=0;i<26;i++)
            if(map[i]>0)
                map[i]++;

        int start = 0 , end = 0 , count =0 , len = p.length();

        while(end < s.length()){
            int lastChar = s.charAt(end) - 'a';
            if(map[lastChar] > 0 ){
                if(map[lastChar] > 1){
                    map[lastChar]--;
                    count++;
                    if (count == len) {
                        answer.add(start);
                        count--;
                        map[s.charAt(start)-'a']++;
                        start++;
                    }
                    end++;
                }else{
                    while(map[lastChar] == 1){
                        map[s.charAt(start)-'a']++;
                        start++;
                        count--;
                    }
                }
            }else{
                count=0;
                while(start < end){
                    map[s.charAt(start)-'a']++;
                    start++;
                }
                    end++;
                    start++;
            }
        }
        return answer;
    }
}