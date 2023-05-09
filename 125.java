class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        String temp = "";
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(lowerCase.charAt(i))) {
                temp += lowerCase.charAt(i);
            }
        }
        for (int i = temp.length() - 1; i >= 0; i--) {
            reverse += temp.charAt(i);
        }
        return temp.equals(reverse);
    }
}