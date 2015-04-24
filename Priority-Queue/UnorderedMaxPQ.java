
/**
 * Unordered Priority Queue implementation using an Array
 *
 * Insertion: constant
 *  Deletion: linear
 *  Find Max: linear
 */


public class UnorderedMaxPQ {
    private int[] pq;
    private int n;

    public UnorderedMaxPQ(int capacity) {
        this.pq = new int[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int x) {
        pq[n++] = x;
    }

    public int delMax() {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (less(max, i)) {
                max = i;
            }
            exchange(max, n - 1);
            return pq[--n]; // null out entry to prevent loitering
        }
    }

    private boolean less(int v, int w) {
        return pq[v] < pq[w];
    }

    private void exchange(int i, int j) {
        int copy = pq[i];
        pq[i] = pq[j];
        pq[j] = copy;
    }
}