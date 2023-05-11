class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] bucket = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            bucket[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (bucket[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }
            bucket[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }
}