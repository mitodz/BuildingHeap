public class Heap {
    private int[] H;

    public Heap(int[] H) {
        this.H = H;
    }

    public void siftUp (int i) {
        while (i > 1 && H[parent(i)]<H[i]) {
            swap(H, i);
            i = parent(i);
        }
    }

    public void swap (int[] H, int i) {
        int t = H[i];
        H[i] = H[parent(i)];
        H[parent(i)] = t;
    }

    public int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

}
