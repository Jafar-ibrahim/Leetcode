class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        char[] string = s.toCharArray();
        Set<Character> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for(char c : string){
            map[c-'a']++;
        }
        int pointer = 0 , counter =0;
        while(pointer < string.length){
            counter++;
            char target = string[pointer];
            if(!set.contains(target))
                set.add(target);

            map[target-'a']--;

            if( map[target-'a'] == 0){ 
                set.remove(target);
                if(set.isEmpty()){
                    answer.add(counter);
                    counter=0;
                }
            }
            pointer++;
        }
        if(counter > 0) answer.add(counter);
        return answer;
    }
}