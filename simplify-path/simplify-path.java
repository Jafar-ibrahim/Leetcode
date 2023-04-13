class Solution {
   public static String simplifyPath(String path) {
        if(path.length()==1) return "/";
        Stack<String> mystack = new Stack<>();
        String[] parts = path.split("/");
        StringBuilder str = new StringBuilder();
        for(int i=0 ; i<parts.length ; i++){
            if(parts[i].equals("..") ){
                if(!mystack.empty())
                    mystack.pop();
            }else if(!Objects.equals(parts[i], "") && !Objects.equals(parts[i], ".") && !Objects.equals(parts[i], "/")){
                mystack.push(parts[i]);
            }
        }
        if (mystack.empty()) return "/";
        while (!mystack.empty()){
            str.insert(0,mystack.pop()).insert(0,"/");
        }
        return str.toString();
    }
}