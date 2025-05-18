
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!hash.containsKey(c) || hash.get(c) == 0) {
                return false;
            }
            hash.put(c, hash.get(c) - 1);
        }

        return true;
    }
}
