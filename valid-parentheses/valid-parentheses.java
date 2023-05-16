class Solution {
    public boolean isValid(String s) {
        if(s.length() %2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        char[] s_array = s.toCharArray();
        for(char c : s_array){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if(!stack.empty() && map.get(stack.peek())==c){
                    stack.pop();
                }else
                    return false;
            }
        }
        return stack.empty();
    }
}