/**
 * You are given an integer array arr of length n that represents a permutation
 * of the integers in the range [0, n - 1].
 * 
 * We split arr into some number of chunks (i.e., partitions), and individually
 * sort each chunk. After concatenating them, the result should equal the sorted
 * array.
 * 
 * Return the largest number of chunks we can make to sort the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2],
 * which isn't sorted.
 * Example 2:
 * 
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks
 * possible.
 * 
 * 
 * Constraints:
 * 
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * All the elements of arr are unique.
 * Accepted
 * 62,849
 * Submissions
 * 110,057
 */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = -1, min = -1, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                if (min <= arr[i] && arr[i] <= max) {

                } else {
                    count++;
                    max = -1;
                    min = -1;
                }
            } else {
                int min2 = Math.min(i, arr[i]);
                int max2 = Math.max(i, arr[i]);
                if (min2 <= max) {
                    min = Math.min(min, min2);
                    max = Math.max(max2, max);
                } else {
                    count++;
                    min = min2;
                    max = max2;
                }

            }
        }

        return count;

    }
}