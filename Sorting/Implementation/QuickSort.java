import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = Integer.parseInt(scan.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        getQuickSort(a, 0, n - 1);
        System.out.println("Here is your sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scan.close();

    }

    public static void getQuickSort(int a[], int l, int h) {
        if (l >= h) {
            return;
        }
        int pivot = a[h];
        int pivotIndex = partition(a, l, h, pivot);
        getQuickSort(a, l, pivotIndex - 1);
        getQuickSort(a, pivotIndex, h);
    }

    public static int partition(int a[], int l, int h, int pivot) {
        int i = l, j = l;
        while (i <= h) {
            if (a[i] > pivot) {
                i++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
