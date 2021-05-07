import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 15; i++) {
            st.push(i);
        }
        while (!st.empty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
        st.push(1);
        st.push(2);
        System.out.println(st.pop());
        System.out.println(st.pop());
        try {

            System.out.println(st.pop());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
