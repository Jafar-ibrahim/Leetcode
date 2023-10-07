class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();

        Map<Integer,char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(digits, map , answer , sb ,0 );
        return answer;
    }

    public static void backtrack(String digits , Map<Integer,char[]> map , List<String> answer , StringBuilder sb , int index){

        //if(index > digits.length() - 1 ) return;

        if(index > digits.length() - 1 ){
            answer.add(sb.toString());
            return;
        }
        int currDigit = Character.getNumericValue(digits.charAt(index));
        char[] currMap =  map.get(currDigit);
        for(int i = 0 ; i < currMap.length ; i++){
            sb.append(currMap[i]);
            backtrack(digits , map , answer , sb , index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}