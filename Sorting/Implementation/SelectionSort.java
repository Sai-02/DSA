import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = Integer.parseInt(scan.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        getSelectionSort(a, n);
        System.out.println("Here is your sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scan.close();

    }

    public static void getSelectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }

    }
}