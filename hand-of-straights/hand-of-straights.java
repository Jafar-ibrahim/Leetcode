class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        Arrays.sort(hand);
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:hand)hm.put(i,hm.getOrDefault(i,0)+1);
        
        for(int i:hand){
            if(hm.get(i)>=1){
                hm.put(i,hm.get(i)-1);
                 int size = 1;
                int mem = i+1;
                while(size<g){
                    if(!hm.containsKey(mem) || hm.get(mem)<=0)return false;
                    hm.put(mem,hm.get(mem)-1);
                    mem++;
                    size++;
                }
            }
        }
        return true;
    }
}