import java.util.HashMap;

class Solution {  
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];

            int min = Math.min(a, b);
            int max = Math.max(a, b);

           
            String key = min + "," + max;


            if (map.containsKey(key)) {
                result += map.get(key);
                map.put(key, map.get(key) + 1); 
            } else {
                map.put(key, 1); 
            }
        }

        return result;
    }
}

