
/**
 * 1. You are given a number n, representing the count of coins. 2. You are
 * given n numbers, representing the denominations of n coins. 3. You are given
 * a number "amt". 4. You are required to calculate and print the number of
 * combinations of the n coins using which the amount "amt" can be paid.
 * 
 * Note1 -> You have an infinite supply of each coin denomination i.e. same coin
 * denomination can be used for many installments in payment of "amt" Note2 ->
 * You are required to find the count of combinations and not permutations i.e.
 * 2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations
 * of same combination. You should treat them as 1 and not 3. Input Format A
 * number n n1 n2 .. n number of elements A number amt Output Format A number
 * representing the count of combinations of coins which can be used to pay the
 * amount "amt" Question Video
 * 
 * COMMENTConstraints 1 <= n <= 30 0 <= n1, n2, .. n elements <= 20 0 <= amt <=
 * 50 Sample Input 4 2 3 5 6 7 Sample Output 2
 */
import java.util.*;

public class Coin_Change_Combination {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int amount = scan.nextInt();
        int dp[] = new int[amount + 1];
        for (int i = 0; i < n; i++) {
            int coin = a[i];
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    if (j - coin >= 0) {
                        dp[j] += dp[j - coin];
                    }
                }
            }
        }
        System.out.println(dp[amount]);
        scan.close();

    }
}

// =====================================================================================
//
// Explanation: https://www.youtube.com/watch?v=l_nR5X9VmaI&t=619s&ab_channel=Pepcoding
//
// ======================================================================================