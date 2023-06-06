class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int min = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    fresh--;
                    queue.offer(new int[] {x, y});
                }
                size--;
            }
            min++;
        }

        if (fresh != 0) return -1;

        return min - 1;
    }
}