package Implementation;

public class Test {
    public static void main(String[] args) {
        DSU dsu = new DSU(5);
        dsu.union(0, 1);
        dsu.union(2, 3);
        System.out.println(dsu.find(1) == dsu.find(0));
        System.out.println(dsu.find(1) == dsu.find(2));
    }
}
