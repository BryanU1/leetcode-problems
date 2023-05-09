class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        dfs(image, sr, sc, val, color);
        return image;
    }
    public void dfs(int[][] image, int i, int j, int val, int newVal) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newVal || image[i][j] != val) {
            return;
        }
        image[i][j] = newVal;
        dfs(image, i+1, j, val, newVal);
        dfs(image, i, j+1, val, newVal);
        dfs(image, i-1, j, val, newVal);
        dfs(image, i, j-1, val, newVal);
    }
}