class Solution {
    public int maxDiff(int num) {
        String numStr = Integer.toString(num);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                String replaced = replaceDigit(numStr, x, y);
                
                if (replaced.charAt(0) != '0') {
                    int val = Integer.parseInt(replaced);
                    max = Math.max(max, val);
                    min = Math.min(min, val);
                }
            }
        }

        return max - min;
    }

    private String replaceDigit(String numStr, int x, int y) {
        char xc = (char) ('0' + x);
        char yc = (char) ('0' + y);
        StringBuilder sb = new StringBuilder();

        for (char c : numStr.toCharArray()) {
            if (c == xc) {
                sb.append(yc);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
