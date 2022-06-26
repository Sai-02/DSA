/**
 * There are several cards arranged in a row, and each card has an associated
 * number of points. The points are given in the integer array cardPoints.
 * 
 * In one step, you can take one card from the beginning or from the end of the
 * row. You have to take exactly k cards.
 * 
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum
 * score you can obtain.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However,
 * choosing the rightmost card first will maximize your total score. The optimal
 * strategy is to take the three cards on the right, giving a final score of 1 +
 * 6 + 5 = 12.
 * Example 2:
 * 
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always
 * be 4.
 * Example 3:
 * 
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points
 * of all cards.
 * 
 * 
 * Constraints:
 * 
 * 1 <= cardPoints.length <= 105
 * 1 <= cardPoints[i] <= 104
 * 1 <= k <= cardPoints.length
 * Accepted
 * 174,701
 * Submissions
 * 335,880
 * Seen this question in a real interview before?
 * 
 * Yes
 * 
 * No
 * 
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int p1[] = new int[k];
        int p2[] = new int[k];
        int sum1 = 0, sum2 = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            p1[i] = cardPoints[i];
            sum1 += p1[i];
        }
        int count = 0;
        for (int i = cardPoints.length - 1; i >= 0 && count < k; i--) {
            sum2 += cardPoints[i];
            p2[count] = cardPoints[i];
            count++;
        }
        int i1 = 0, i2 = 0, j1 = k - 1, j2 = k - 1;
        while (k-- > 0) {
            if (sum1 > sum2) {
                sum += p1[i1];
                sum1 -= p1[i1++];
                sum2 -= p2[j2--];
            } else {
                sum += p2[i2];
                sum2 -= p2[i2++];
                sum1 -= p1[j1--];
            }
        }
        return sum;
    }
}