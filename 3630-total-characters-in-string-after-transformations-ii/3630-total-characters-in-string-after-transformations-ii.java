class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int SIZE = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[SIZE];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long[][] mat = new long[SIZE][SIZE];

        // בניית מטריצת טרנספורמציה
        for (int i = 0; i < SIZE; i++) {
            int n = nums.get(i);
            for (int k = 1; k <= n; k++) {
                int to = (i + k) % SIZE;
                mat[to][i] = (mat[to][i] + 1) % MOD;
            }
        }

        long[][] matPow = matrixPower(mat, t);

        long result = 0;
        for (int i = 0; i < SIZE; i++) {
            long sum = 0;
            for (int j = 0; j < SIZE; j++) {
                sum = (sum + matPow[i][j] * freq[j]) % MOD;
            }
            result = (result + sum) % MOD;
        }

        return (int) result;
    }

    private long[][] matrixPower(long[][] mat, int power) {
        long[][] result = identityMatrix();
        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, mat);
            mat = multiply(mat, mat);
            power >>= 1;
        }
        return result;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < SIZE; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] identityMatrix() {
        long[][] id = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            id[i][i] = 1;
        }
        return id;
    }
}