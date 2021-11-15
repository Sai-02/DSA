
/**
 * 1. You are given a number n, representing the count of items. 2. You are
 * given n numbers, representing the values of n items. 3. You are given n
 * numbers, representing the weights of n items. 3. You are given a number
 * "cap", which is the capacity of a bag you've. 4. You are required to
 * calculate and print the maximum value that can be created in the bag without
 * overflowing it's capacity. Note1 -> Items can be added to the bag even
 * partially. But you are not allowed to put same items again and again to the
 * bag. Input Format A number n v1 v2 .. n number of elements w1 w2 .. n number
 * of elements A number cap Output Format A decimal number representing the
 * maximum value that can be created in the bag without overflowing it's
 * capacity Question Video
 * 
 * Constraints 1 <= n <= 20 0 <= v1, v2, .. n elements <= 50 0 < w1, w2, .. n
 * elements <= 10 0 < cap <= 10 Sample Input 10 33 14 50 9 8 11 6 40 2 15 7 2 5
 * 9 3 2 1 10 3 3 5 Sample Output 50.0
 * 
 * 
 * Asked in Companies Related Topics
 */
import java.util.*;

public class Fractional_Knapsack {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int values[] = new int[n];
        int weights[] = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            values[i] = scan.nextInt();
        }

        int capacity = scan.nextInt();
        getQuickSort(values, weights, 0, n - 1);
        double ans = 0;
        int i = n - 1;
        while (capacity > 0) {
            if (capacity >= values[i]) {
                ans += weights[i];
            } else {
                ans += ((double) weights[i] / (double) values[i]) * capacity;
            }
            capacity -= values[i];
            i--;
        }
        System.out.println(ans);
        scan.close();

    }

    public static void getQuickSort(int values[], int weights[], int l, int h) {
        if (l >= h) {
            return;
        }
        double pivot = ((double) weights[h]) / ((double) values[h]);
        int pivotIndex = partition(values, weights, l, h, pivot);
        getQuickSort(values, weights, l, pivotIndex - 1);
        getQuickSort(values, weights, pivotIndex, h);
    }

    public static int partition(int values[], int weights[], int l, int h, double pivot) {
        int i = l, j = l;
        while (i <= h) {
            if (((double) weights[i] / (double) values[i]) > pivot) {
                i++;
            } else {
                swap(values, weights, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static void swap(int values[], int weights[], int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        temp = weights[i];
        weights[i] = weights[j];
        weights[j] = temp;

    }

}