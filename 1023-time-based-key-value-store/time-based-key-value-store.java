 class TimeMap {

        Map<String,TreeMap<Integer,String>> map ;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<Integer, String>());
            map.get(key).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            if(map.get(key) != null) {
                TreeMap<Integer, String> currMap = map.get(key);
                if (currMap.get(timestamp) != null)
                    return currMap.get(timestamp);
                
                Integer floorKey = currMap.floorKey(timestamp);
                if (floorKey != null) {
                    return currMap.get(floorKey);
                }
            }

            return "";
        }
    }