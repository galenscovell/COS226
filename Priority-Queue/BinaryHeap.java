
/**
 * Binary Heap implementation
 *
 * Insertion: Logarithmic (add node at end, then swim it up) (max 1 + log(n) compares)
 *  Deletion: Logarithmic (exchange root with node at end, then sink it down) (max 2log(n) compares)
 *  Find Max: Constant (root is max value)
 */


public class BinaryHeap {
    private int[] pq;
    private int n;

    public BinaryHeap(int capacity) {
        // Fixed size for simplicity, can utilize dynamic resizing array instead
        this.pq = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int key) {
        pq[++n] = x;
        swim(n);
    }

    public int delMax() {
        int max = pq[1];
        exchange(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exchange(k, j);
            k = j;
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