class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] map = new int[strs.length][26];
        List<List<String>> answer = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i=0 ; i<strs.length ;i++ ){
            for(int j=0 ; j<strs[i].length();j++){
                map[i][strs[i].charAt(j) -'a']++;
            }
        }
        for(int i=0 ; i<strs.length ;i++ ){
            if(!visited[i]){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                visited[i] = true;
                for(int j=i+1 ; j<strs.length ;j++ ){
                    if(!visited[j] && Arrays.equals(map[i],map[j])){
                        temp.add(strs[j]);
                        visited[j] = true;
                    }  
                }
                    answer.add(temp);    
        }
        } 
        
        return answer;
    }
}