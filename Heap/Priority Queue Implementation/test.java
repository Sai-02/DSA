import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue pq = new PriorityQueue();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scan.nextInt();
            pq.add(value);

        }
        for (int i = 0; i < n; i++) {
            System.out.print(pq.remove() + " ");
        }
        System.out.println();
    }
}