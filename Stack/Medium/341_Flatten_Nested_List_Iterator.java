
/**
 * You are given a nested list of integers nestedList. Each element is either an
 * integer or a list whose elements may also be integers or other lists.
 * Implement an iterator to flatten it.
 * 
 * Implement the NestedIterator class:
 * 
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with
 * the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested
 * list and false otherwise.
 * Your code will be tested with the following pseudocode:
 * 
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * If res matches the expected flattened list, then your code will be judged as
 * correct.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * 
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,4,6].
 * 
 * 
 * Constraints:
 * 
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 * Accepted
 * 262,212
 * Submissions
 * 454,555
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation*/

import java.util.*;
import java.util.Stack;
import java.util.Iterator;

public interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    Stack<Integer> stIndex = new Stack<>();
    Stack<List<NestedInteger>> stList = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        stIndex.push(0);
        stList.push(nestedList);
    }

    @Override
    public Integer next() {

        int val = stList.peek().get(stIndex.peek()).getInteger();
        stIndex.push(stIndex.pop() + 1);

        return val;

    }

    @Override
    public boolean hasNext() {
        while (!stIndex.empty() && stIndex.peek() >= stList.peek().size()) {
            stIndex.pop();
            stList.pop();
        }
        while (!stList.empty() && !stList.peek().get(stIndex.peek()).isInteger()) {
            stIndex.push(stIndex.pop() + 1);
            if (stList.peek().get(stIndex.peek() - 1).getList().size() > 0) {
                stList.push(stList.peek().get(stIndex.peek() - 1).getList());
                stIndex.push(0);
            }
            while (!stIndex.empty() && stIndex.peek() >= stList.peek().size()) {
                stIndex.pop();
                stList.pop();
            }

        }

        return !stIndex.empty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */