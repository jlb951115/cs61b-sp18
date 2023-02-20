public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<Integer>();
        ArrayDeque.addLast(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addLast(2);
        int i = ArrayDeque.get(1);
        i = ArrayDeque.removeLast();
        i = ArrayDeque.removeFirst();
        i = ArrayDeque.removeFirst();
        ArrayDeque.addFirst(7);
        i = ArrayDeque.get(0);
        ArrayDeque.addFirst(9);
        i = ArrayDeque.removeLast();
        i = ArrayDeque.get(0);
        i = ArrayDeque.removeFirst();
        ArrayDeque.addFirst(13);
        ArrayDeque.addLast(14);
        i = ArrayDeque.removeFirst();
        ArrayDeque.addFirst(16);
        ArrayDeque.addLast(17);
        ArrayDeque.addFirst(18);
        i = ArrayDeque.get(1);
    }
}
