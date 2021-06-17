import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = Integer.parseInt(scan.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        getBubbleSort(a, n);
        System.out.println("Here is your sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scan.close();
    }

    public static void getBubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }
}