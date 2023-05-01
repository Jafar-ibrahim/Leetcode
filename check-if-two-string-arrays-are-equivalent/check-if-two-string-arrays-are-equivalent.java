class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int array_counter1 = 0 , array_counter2 = 0, char1 =0 , char2=0 ;
        while(array_counter1 < word1.length && array_counter2 < word2.length){
            if(!(word1[array_counter1].charAt(char1) ==
                 word2[array_counter2].charAt(char2) )){
                     return false;
                 }

            if(char1 == word1[array_counter1].length()-1){
                array_counter1++;
                char1 = 0;
            }else
                char1++;

            if(char2 == word2[array_counter2].length()-1){
                array_counter2++;
                char2 = 0;
            }else
                char2++;
        }
        return (array_counter1 == word1.length && 
                array_counter2 ==word2.length);
    }
}