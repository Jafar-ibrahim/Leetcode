class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0 ;
        for(int n : piles){
            if(n>max) max = n;
        } 
        int left = 1 , right = max ;
        int result = Integer.MAX_VALUE;
        while(left <= right){

            int mid = left + (right - left)/2;
            long current = getTotal(piles , mid);
        
            if(current <= h) {
                right = mid - 1;
                result = Math.min(result,mid);
            }else {
                left = mid +1 ;
            }
        }
        return result;
    }

    public static long getTotal(int[] piles , int k){
        
        long total = 0 ;
        for(int n : piles){
            total += ( n / k);
            if(n%k != 0) total++;
        }
        return total;
    }
}