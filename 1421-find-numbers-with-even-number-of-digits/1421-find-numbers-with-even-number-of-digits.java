class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(Math.abs(num)).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}