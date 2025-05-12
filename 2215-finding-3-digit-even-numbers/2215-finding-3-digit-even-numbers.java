import java.util.*;

public class Solution {

    public static int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) count[d]++;
        Set<Integer> result = new HashSet<>();

        // ספרת יחידות חייבת להיות זוגית
        for (int u = 0; u <= 9; u += 2) {
            if (count[u] == 0) continue;
            count[u]--;

            for (int a = 0; a <= 9; a++) {
                if (count[a] == 0 || a == 0) continue;
                count[a]--;

                for (int b = 0; b <= 9; b++) {
                    if (count[b] == 0) continue;
                    int num = a * 100 + b * 10 + u;
                    result.add(num);
                }

                count[a]++;
            }

            count[u]++;
        }

        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


}
