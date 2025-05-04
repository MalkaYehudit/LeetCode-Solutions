import java.util.HashMap;

class Solution {  // Change this from 'solution' to 'Solution'
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            // creating a key in the form "1,2"
            String key = min + "," + max;

            // if we've seen this domino before, add the previous count to the result
            if (map.containsKey(key)) {
                result += map.get(key);
                map.put(key, map.get(key) + 1); // incrementing the count
            } else {
                map.put(key, 1); // first occurrence of this domino
            }
        }

        return result;
    }
}

