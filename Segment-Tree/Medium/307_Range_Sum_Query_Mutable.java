/**
 * Given an integer array nums, handle multiple queries of the following types:
 * 
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right
 * inclusive where left <= right.
 * Implement the NumArray class:
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums
 * between indices left and right inclusive (i.e. nums[left] + nums[left + 1] +
 * ... + nums[right]).
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 * 
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2); // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 104 calls will be made to update and sumRange.
 */

class NumArray {
    int tree[];
    int nums[];

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length * 4];
        build(0, 0, nums.length - 1);
    }

    public void build(int index, int l, int r) {
        if (l == r) {
            tree[index] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * index + 1, l, mid);
        build(2 * index + 2, mid + 1, r);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public void update(int index, int val) {
        updateElement(0, 0, nums.length - 1, index, val);
    }

    public void updateElement(int node, int tl, int tr, int index, int val) {
        if (tl == tr) {
            tree[node] = val;
            return;
        }
        int tm = (tl + tr) / 2;
        if (index <= tm) {
            updateElement(2 * node + 1, tl, tm, index, val);
        } else {
            updateElement(2 * node + 2, tm + 1, tr, index, val);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        return sum(0, 0, nums.length - 1, left, right);
    }

    public int sum(int node, int tl, int tr, int l, int r) {
        if (l <= tl && r >= tr)
            return tree[node];
        if (l > tr || r < tl)
            return 0;
        int tm = (tl + tr) / 2;
        return sum(2 * node + 1, tl, tm, l, r) + sum(2 * node + 2, tm + 1, tr, l, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */