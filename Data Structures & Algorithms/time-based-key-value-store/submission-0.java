class TimeMap {
    private Map<String, Map<Integer, String>> mainMap;

    public TimeMap() {
        mainMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!mainMap.containsKey(key)) {
            Map<Integer, String> map = new HashMap<>(Map.of(timestamp, value));
            mainMap.put(key, map);
        } else {
            mainMap.get(key).put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!mainMap.containsKey(key)) {
            return "";
        }
        
        Map<Integer, String> timeMap = mainMap.get(key);
        
        if (timeMap.containsKey(timestamp)){
            return timeMap.get(timestamp); 
        }

        int maxTargetTime = -1;
        
        for (int t : timeMap.keySet()) {
            if (t < timestamp && t > maxTargetTime) {
                maxTargetTime = t;
            }
        }
        
        return maxTargetTime != -1 ? timeMap.get(maxTargetTime) : "";
    }
}
