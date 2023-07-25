 class subMap{
        TreeMap<Integer,String> innerMap ;
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
            if(map.get(key) != null) {
                TreeMap<Integer, String> currMap = map.get(key).innerMap;
                if (currMap.get(timestamp) != null)
                    return currMap.get(timestamp);
                if (timestamp >= map.get(key).lastAdded)
                    return currMap.get(map.get(key).lastAdded);

                Integer floorKey = currMap.floorKey(timestamp);
                if (floorKey != null) {
                    return currMap.get(floorKey);
                }
            }

            return "";
        }
    }