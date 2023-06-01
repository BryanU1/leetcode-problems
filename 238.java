class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            res[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        return res;
    }
}