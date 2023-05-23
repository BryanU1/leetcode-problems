class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    public void quickSort(int[][] points, int l, int r, int k) {
        if (l < r) {
            int index = partition(points, l, r);
            if (index == k) {
                return;
            } else if (index < k) {
                quickSort(points, index + 1, r, k);
            } else {
                quickSort(points, l, index - 1, k);
            }
        }
    }

    public int partition(int[][] points, int l, int r) {
        int[] pivot = points[r];
        int a = l;
        for (int i = l; i < r; i++) {
            if (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2) <= Math.pow(pivot[0], 2) + Math.pow(pivot[1], 2)) {
                int[] temp = points[i];
                points[i] = points[a];
                points[a] = temp;
                a += 1;
            }
        }
        int[] temp = points[a];
        points[a] = points[r];
        points[r] = temp;
        return a;
    }
}