import java.util.ArrayList;

class PriorityQueue {
    private ArrayList<Integer> a = new ArrayList<>();

    void add(int element) {
        a.add(element);
        upheapify(a.size() - 1);

    }

    private void swap(int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    private void upheapify(int i) {
        if (i == 0) {
            return;
        }
        int pi = (i - 1) / 2;
        if (a.get(i) < a.get(pi)) {
            swap(i, pi);
            upheapify(pi);

        }
    }

    int size() {
        return a.size();
    }

    boolean isEmpty() {
        if (a.size() == 0) {
            return true;
        }
        return false;
    }

    int peek() throws NullPointerException {
        if (a.size() == 0) {
            throw new NullPointerException();

        }
        return a.get(0);
    }

    int remove() throws NullPointerException {
        if (a.size() == 0) {
            throw new NullPointerException();
        }
        swap(0, a.size() - 1);
        int removedElement = a.get(a.size() - 1);
        a.remove(a.size() - 1);
        downheapify(0);
        return removedElement;

    }

    private void downheapify(int i) {
        int mini = i;
        int li = 2 * i + 1;
        if (li < a.size() && a.get(li) < a.get(mini)) {
            mini = li;
        }

        int ri = 2 * i + 2;
        if (ri < a.size() && a.get(ri) < a.get(mini)) {
            mini = ri;
        }
        if (mini != i) {
            swap(i, mini);
            downheapify(mini);
        }

    }

}