class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] coverage = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            coverage[l] += 1;
            if (r + 1 < n) coverage[r + 1] -= 1;
        }

        int current = 0;
        for (int i = 0; i < n; i++) {
            current += coverage[i];
            if (current < nums[i]) return false;
        }

        return true;
    }
}
