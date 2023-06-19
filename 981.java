class TimeMap {
    Map<String, TreeMap<Integer, String>> hashmap;
    public TimeMap() {
        hashmap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!hashmap.containsKey(key)) {
            hashmap.put(key, new TreeMap<Integer, String>());
        }
        hashmap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> temp = hashmap.get(key);
        if (!hashmap.containsKey(key)) return "";
        Integer i = temp.floorKey(timestamp);
        if (i != null) return temp.get(i);
        return "";
    }
}