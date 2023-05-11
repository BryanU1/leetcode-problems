class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int x = 1;
        int y = 2;
        int z;
        for (int i = 3; i < n; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return x + y;
    }
}