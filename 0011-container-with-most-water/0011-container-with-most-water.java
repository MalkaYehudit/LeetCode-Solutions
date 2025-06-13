class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
    }
}
