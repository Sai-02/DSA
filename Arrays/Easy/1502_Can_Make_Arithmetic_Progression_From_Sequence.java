/**
 * A sequence of numbers is called an arithmetic progression if the difference
 * between any two consecutive elements is the same.
 * 
 * Given an array of numbers arr, return true if the array can be rearranged to
 * form an arithmetic progression. Otherwise, return false.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [3,5,1]
 * Output: true
 * Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with
 * differences 2 and -2 respectively, between each consecutive elements.
 * Example 2:
 * 
 * Input: arr = [1,2,4]
 * Output: false
 * Explanation: There is no way to reorder the elements to obtain an arithmetic
 * progression.
 * 
 * 
 * Constraints:
 * 
 * 2 <= arr.length <= 1000
 * -106 <= arr[i] <= 106
 * Accepted
 * 166,422
 * Submissions
 * 238,580
 */

// O(n) - TC Approach

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        if ((max - min) % (arr.length - 1) != 0)
            return false;
        int diff = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length;) {
            if (arr[i] == (min + (i) * diff))
                i++;
            else if ((arr[i] - min) % diff != 0)
                return false;
            else {
                int j = (arr[i] - min) / diff;
                if (arr[i] == arr[j])
                    return false;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return true;
    }
}