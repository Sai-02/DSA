/*

 */

// { Driver Code Starts
import java.util.*;

public class Largest_subarray_with_0_sum {

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG2 g = new GfG2();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends

class GfG2 {
    int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }

        }
        return maxLength;
    }
}
