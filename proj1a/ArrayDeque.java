public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return items[index];
    }

    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        int number = size;
        int i = 0;
        int index = nextfirst;
        while (number > 0) {
            a[i] = items[plusone(index, items.length)];
            i++;
            number--;
            index = plusone(index, items.length);
        }
        items = a;
        nextfirst = minusone(0, items.length);
        nextlast = size;
    }
    private int minusone(int index, int capt) {
        if (index - 1 < 0) {
            return capt - 1;
        }
        else {
            return index - 1;
        }
    }

    private int plusone(int index, int capt) {
        if (index + 1 == capt) {
            return 0;
        }
        else {
            return index + 1;
        }
    }
    public void addFirst(T item) {
        if (size == items.length)
            resize(size * 2);
        items[nextfirst] = item;
        size += 1;
        if (size == 1){
            nextfirst = minusone(nextfirst, items.length);
            nextlast = plusone(nextlast, items.length);
        }
        else{
            nextfirst = minusone(nextfirst, items.length);
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextlast] = item;
        size += 1;
        if (size == 1){
            nextfirst = minusone(nextfirst, items.length);
            nextlast = plusone(nextlast, items.length);
        }
        else{
            nextlast = plusone(nextlast, items.length);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        nextfirst = plusone(nextfirst, items.length);
        T item = items[nextfirst];
        if (items.length < 16) {
            return item;
        }
        else if (size < items.length * 0.25){
            resize(2 * size);
            return item;
        }
        else {
            return item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        nextlast = minusone(nextlast, items.length);
        T item = items[nextlast];
        if (items.length < 16) {
            return item;
        }
        else if (size < items.length * 0.25){
            resize(2 * size);
            return item;
        }
        else {
            return item;
        }
    }

    public void printDeque() {
        int i = 0;
        int index = nextfirst;
        while(i < size) {
            System.out.print(items[plusone(index, items.length)]);
            System.out.print(" ");
            index = plusone(index, items.length);
            i++;
        }
        System.out.print("\n");
    }
}
