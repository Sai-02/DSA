import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = Integer.parseInt(scan.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        a = getMergeSort(a, 0, n - 1);
        System.out.println("Here is your sorted array");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        scan.close();
    }

    public static int[] getMergeSort(int a[], int l, int h) {
        if (l == h) {
            int ans[] = new int[1];
            ans[0] = a[l];
            return ans;
        }
        int mid = (l + h) / 2;
        int lsa[] = getMergeSort(a, l, mid);
        int rsa[] = getMergeSort(a, mid + 1, h);
        int ans[] = merge(lsa, rsa);

        return ans;
    }

    public static int[] merge(int a[], int b[]) {
        int ans[] = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        int n = a.length;
        int m = b.length;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans[k++] = a[i++];
            } else {
                ans[k++] = b[j++];
            }
        }
        while (i < n) {
            ans[k++] = a[i++];

        }
        while (j < m) {
            ans[k++] = b[j++];
        }
        return ans;
    }
}