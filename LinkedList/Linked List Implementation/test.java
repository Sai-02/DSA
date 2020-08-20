import java.util.*;

public class test {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add(a, 1);
        a.add(a, 2);
        a.add(a, 3);
        a.add(a, 4);
        a.add(a, 5);
        a.add(a, 6);

        a.printList(a);
        System.out.println();
        System.out.println(a.size(a));
        a.add(a, 34);
        System.out.println(a.size(a));
        System.out.println(a.indexOf(a, 5));
        a.remove(a, 34);
        a.printList(a);
        System.out.println();
        a.set(a, 3, 100);
        a.printList(a);
        System.out.println();
        System.out.println(a.get(a, 4));
        a.reverse(a);
        a.printList(a);
        a.reverse(a);
        System.out.println();
        a.printList(a);

    }

}