/**
 * (This problem is an interactive problem.)
 * 
 * You may recall that an array arr is a mountain array if and only if:
 * 
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that
 * mountainArr.get(index) == target. If such an index does not exist, return -1.
 * 
 * You cannot access the mountain array directly. You may only access the array
 * using a MountainArray interface:
 * 
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged
 * Wrong Answer. Also, any solutions that attempt to circumvent the judge will
 * result in disqualification.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the
 * minimum index, which is 2.
 * Example 2:
 * 
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * 
 * 
 * Constraints:
 * 
 * 3 <= mountain_arr.length() <= 104
 * 0 <= target <= 109
 * 0 <= mountain_arr.get(index) <= 109
 * Accepted
 * 46,234
 * Submissions
 * 128,879
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        int peakIndex = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                l++;
                continue;
            }
            if (mid == mountainArr.length() - 1) {
                r--;
                continue;
            }
            if (mountainArr.get(mid - 1) < mountainArr.get(mid) && mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                peakIndex = mid;
                if (mountainArr.get(mid) == target)
                    return mid;
                break;
            } else if (mountainArr.get(mid - 1) < mountainArr.get(mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (target > mountainArr.get(peakIndex))
            return -1;
        int index = search1(mountainArr, 0, peakIndex, target);
        if (index != -1)
            return index;
        return search2(mountainArr, peakIndex, mountainArr.length() - 1, target);

    }

    public static int search1(MountainArray mountainArr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static int search2(MountainArray mountainArr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) < target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}