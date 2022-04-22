public class test {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 12);
        System.out.println(hm.keyset());
        System.out.println(hm.get(1));
        hm.put(1, 14);
        System.out.println(hm.get(1));
        System.out.println(hm.containsKey(1));
        hm.remove(1);
        System.out.println(hm.keyset());

    }
}
