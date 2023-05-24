class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                j = Math.max(j, hm.get(s.charAt(i)) + 1);
            }
            hm.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}