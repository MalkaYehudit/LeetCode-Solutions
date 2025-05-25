
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> hash = new HashMap<>();
        boolean flag = false;
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String rev = "" + word.charAt(1) + word.charAt(0);

            if (hash.containsKey(rev) && hash.get(rev) > 0) {
                ans += 4;
                hash.put(rev, hash.get(rev) - 1);
            } else {
                hash.put(word, hash.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : hash.keySet()) {
            if (key.charAt(0) == key.charAt(1) && hash.get(key) > 0) {
                ans += 2;
                break;
            }
        }

        return ans;
    }
}
