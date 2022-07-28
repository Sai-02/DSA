
/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 * 
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >
 * 2 * nums[j].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,2,3,1]
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [2,4,3,5,1]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 * Accepted
 * 95,712
 * Submissions
 * 313,322
 */
import java.util.*;

class Solution {
    int pairs = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return pairs;
    }

    public int[] mergeSort(int nums[]) {
        if (nums.length == 1)
            return nums;
        int mid = nums.length / 2;
        int lp[] = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int rp[] = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        int count = 0;
        for (int i = 0, j = 0; i < lp.length; i++) {
            while (j < rp.length) {
                if (rp[j] < lp[i] / 2.0) {
                    count++;
                    j++;
                } else
                    break;
            }
            pairs += count;
        }
        return merge(lp, rp);
    }

    public int[] merge(int lp[], int rp[]) {
        int ans[] = new int[lp.length + rp.length];
        int i = 0, j = 0, index = 0;
        while (i < lp.length && j < rp.length) {
            if (lp[i] > rp[j]) {
                ans[index++] = rp[j++];
            } else {
                ans[index++] = lp[i++];
            }
        }
        while (i < lp.length) {
            ans[index++] = lp[i++];
        }
        while (j < rp.length) {
            ans[index++] = rp[j++];
        }
        return ans;
    }
}