import java.util.Hashtable;

class Solution {
    public int removeDuplicates(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int place = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(nums[i])) {
                table.put(nums[i], 1);
                nums[place++] = nums[i];
            } else if (table.get(nums[i]) < 2) {
                table.put(nums[i], table.get(nums[i]) + 1);
                nums[place++] = nums[i];
            }
        }
        return place;
    }
}
