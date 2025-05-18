from itertools import product

class Solution: 
    MOD = 10**9 + 7

    def colorTheGrid(self, m: int, n: int) -> int:

        colors = [0, 1, 2]
        valid_cols = []

        def is_valid(col):
            for i in range(1, len(col)):
                if col[i] == col[i-1]:
                    return False
            return True

        for col in product(colors, repeat=m):
            if is_valid(col):
                valid_cols.append(col)

 
        transitions = {}
        for c1 in valid_cols:
            transitions[c1] = []
            for c2 in valid_cols:
                if all(a != b for a, b in zip(c1, c2)):
                    transitions[c1].append(c2)

 
        dp = {col: 1 for col in valid_cols}  # initial column

        for _ in range(1, n):
            new_dp = {}
            for col in valid_cols:
                new_dp[col] = 0
                for prev_col in transitions[col]:
                    new_dp[col] = (new_dp[col] + dp[prev_col]) % Solution.MOD
            dp = new_dp

        return sum(dp.values()) % Solution.MOD
