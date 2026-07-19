class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            List<Pair> valueList = map.get(key);
            return binarySearch(valueList, timestamp);
        }
    }

    public String binarySearch(List<Pair> valueList, int targetTime) {
        if (targetTime < valueList.get(0).timeStamp) {
            return "";
        }
        int left = 0;
        int right = valueList.size()-1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int midTime = valueList.get(mid).timeStamp;
            if (midTime == targetTime) {
                return valueList.get(mid).value;
            } else if (midTime > targetTime) {
                right = mid;
            } else if (midTime < targetTime) {
                left = mid;
            } 
        }
        if (valueList.get(right).timeStamp <= targetTime) {
            return valueList.get(right).value;
        }
        return valueList.get(left).value;
    }


    public class Pair {
        String value;
        int timeStamp;
        public Pair(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
}
