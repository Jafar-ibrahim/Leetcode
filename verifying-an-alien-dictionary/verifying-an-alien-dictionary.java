class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        char[] alphabet = order.toCharArray();
        for(int i=0;i<order.length();i++){
            map.put(alphabet[i],i);
        }
        for(int i=0;i<words.length-1;i++){
            if(!compareWords(words[i],words[i+1],map)) return false;
        }
        return true;


    }
    public static boolean compareWords(String s1 , String s2 , Map<Character,Integer> map){
        int p1 = 0 , p2 = 0 ;
        while(p1 < s1.length() && p2 < s2.length()){
            if(map.get(s1.charAt(p1)) > map.get(s2.charAt(p2))) 
                return false;
            else if(map.get(s1.charAt(p1)) < map.get(s2.charAt(p2)))
                return true;
            p1++;
            p2++;
        }
        return s1.length() <= s2.length();
    }
}