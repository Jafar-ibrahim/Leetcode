class subMap{
    Map<Integer,String> innerMap ;
    int lastAdded;
    
    public subMap(){
        innerMap = new TreeMap<>();
        lastAdded = 0;
    }
}

class TimeMap {

    Map<String,subMap> map ;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.get(key) == null){
            map.put(key,new subMap());
        }
        map.get(key).innerMap.put(timestamp,value);
        if(map.get(key).lastAdded < timestamp)
            map.get(key).lastAdded = timestamp;
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null) 
            return "";
        Map<Integer,String> currMap = map.get(key).innerMap;
        if(currMap.get(timestamp) != null)
            return currMap.get(timestamp);
        if(timestamp >= map.get(key).lastAdded) 
            return currMap.get(map.get(key).lastAdded);

        List<Integer> keyList
            = new ArrayList<Integer>(currMap.keySet());
        int left = 0 , right = keyList.size()-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(keyList.get(mid) == timestamp)
                return currMap.get(keyList.get(mid));
            else if (keyList.get(mid) > timestamp)
                        right = mid - 1;
            else
                        left = mid + 1;
        }
        if(right < 0 )
            return "";

        return currMap.get(keyList.get(right));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */