class Solution {
    int[] DIR = new int[] {0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 1) {
                    mat[r][c] = -1;
                } else {
                    q.add(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < DIR.length - 1; i++) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nc < 0 || nr == mat.length || nc == mat[0].length || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return mat;
    }
}