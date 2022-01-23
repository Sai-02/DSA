
/**
 * 1. You are given a number n, representing the number of houses.
 * 2. In the next n rows, you are given 3 space separated numbers representing
 * the cost of painting nth house with red or blue or green color.
 * 3. You are required to calculate and print the minimum cost of painting all
 * houses without painting any consecutive house with same color.
 * 
 * Constraints
 * 1 <= n <= 1000
 * 0 <= n1red, n1blue, .. <= 1000
 * 
 * Format
 * Input
 * A number n
 * n1red n1blue n1green
 * n2red n2blue n2green
 * .. n number of elements
 * 
 * Output
 * A number representing the minimum cost of painting all houses without
 * painting any consecutive house with same color.
 * 
 * Example
 * Sample Input
 * 
 * 4
 * 1 5 7
 * 5 8 4
 * 3 2 9
 * 1 2 4
 * 
 * Sample Output
 * 8
 */
import java.util.*;

public class Paint_House {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int red = a[0][0], blue = a[0][1], green = a[0][2];
        for (int i = 1; i < n; i++) {
            int newRed = Math.min(blue, green) + a[i][0];
            int newBlue = Math.min(red, green) + a[i][1];
            int newGreen = Math.min(red, blue) + a[i][2];
            red = newRed;
            blue = newBlue;
            green = newGreen;
        }
        System.out.println(Math.min(red, Math.min(green, blue)));
        scan.close();
    }
}