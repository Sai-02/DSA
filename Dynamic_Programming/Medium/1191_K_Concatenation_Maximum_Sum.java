/**
 * Given an integer array arr and an integer k, modify the array by repeating it
 * k times.
 * 
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2,
 * 1, 2, 1, 2].
 * 
 * Return the maximum sub-array sum in the modified array. Note that the length
 * of the sub-array can be 0 and its sum in that case is 0.
 * 
 * As the answer can be very large, return the answer modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,2], k = 3
 * Output: 9
 * Example 2:
 * 
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 * Example 3:
 * 
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 105
 * 1 <= k <= 105
 * -104 <= arr[i] <= 104
 */
class Solution {
    int mod = (int) Math.pow(10, 9) + 7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
            sum = sum % mod;
        }
        if (k == 1) {
            return getMaxSum(arr) % mod;
        } else if (sum < 0) {
            int newArr[] = new int[2 * arr.length];
            for (int i = 0; i < arr.length; i++)
                newArr[i] = arr[i];
            for (int i = 0; i < arr.length; i++)
                newArr[i + arr.length] = arr[i];
            return getMaxSum(newArr) % mod;
        } else {
            int newArr[] = new int[2 * arr.length];
            for (int i = 0; i < arr.length; i++)
                newArr[i] = arr[i];
            for (int i = 0; i < arr.length; i++)
                newArr[i + arr.length] = arr[i];
            return getMaxSum(newArr) + (int) ((long) (k - 2) * sum % mod);
        }
    }

    public int getMaxSum(int a[]) {
        long prev = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            long newSum = Math.max(a[i], a[i] + prev);
            max = Math.max(max, newSum);
            prev = newSum;
        }
        return (int) Math.max(max, 0) % mod;
    }
}