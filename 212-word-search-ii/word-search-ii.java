class TrieNode{
    TrieNode[] children = new TrieNode[26];;
    String word;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> answer = new ArrayList();
        TrieNode trie = new TrieNode();
        buildTrie(trie , words);


        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                
                    backtrack(board,words,trie,answer,i,j);
            }
        }

        return answer;
    }

    public static void backtrack(char[][] board, String[] words,TrieNode trie,List<String> answer , int row , int col){

        char c = board[row][col];

if(c == '#' || trie.children[c-'a'] == null)
            return;

        trie = trie.children[c-'a'];
        if(trie.word != null ){
            answer.add(trie.word);
            trie.word = null;
        }
        

        
 
        board[row][col] = '#';
        if(row-1 >= 0) 
            backtrack(board,words,trie,answer,row-1,col);
        if(col-1 >= 0) 
            backtrack(board,words,trie,answer,row,col-1);
        if(row+1 < board.length) 
            backtrack(board,words,trie,answer,row+1,col);
        if(col+1 < board[0].length) 
            backtrack(board,words,trie,answer,row,col+1);
        
        board[row][col] = c;
    }

    public static void buildTrie(TrieNode root , String[] words){

        for(String word : words){
            TrieNode curr = root;
            char[] wordChars = word.toCharArray();
            for(int i = 0 ; i < wordChars.length ; i++){
                int index = wordChars[i] - 'a';
                
                if(curr.children[index] == null)
                    curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }
            curr.word = word; 
        }
    }
}