class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backtrack(answer ,s , sb , 0 , 0);
        return answer;
    }

    public static void backtrack(List<String> answer ,String given, StringBuilder sb   , int dotsCount , int index){

        if(dotsCount == 3 ){
            if (isValid(sb, sb.length()-1))
                answer.add(sb.toString());
            return;
        }

        for(int i = index ; i < given.length() + dotsCount; i++){
            if(sb.charAt(i)=='.' || !isValid(sb , i))
                continue;
            sb.insert(i+1,'.');
            backtrack(answer , given , sb , dotsCount +1 ,i+2);
            sb.delete(i+1 , i+2);
        }

    }

    public static boolean isValid(StringBuilder sb , int index ){
        int start = index;

        while(start > 0 && sb.charAt(start) != '.'){  // 25525511135
            if(index - start > 3) return false;
            start--;
        }

        String sectionString =(start > 0)? sb.substring(start+1,index+1) : sb.substring(start,index+1);
        if(sectionString.isEmpty() || sectionString.length() > 1 && sectionString.charAt(0) == '0')
            return false;
        int sectionNumber = Integer.parseInt(sectionString);

        return sectionNumber <= 255;


    }
}