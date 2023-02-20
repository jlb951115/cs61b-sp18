import java.awt.*;

public class LinkedListDeque<T> {
    private class DequeNode {
        public T item;
        public DequeNode next;
        public DequeNode prev;
        public DequeNode(T i, DequeNode n, DequeNode x){
            item = i;
            next = n;
            prev = x;
        }
    }
    private DequeNode sentinel;
    private DequeNode last;
    private int size;
    public int size(){
        return  size;
    }

    public boolean isEmpty(){
        return sentinel.next == null;
    }

    public void printDeque(){
        DequeNode P = sentinel;
        while(P.next != null) {
            System.out.print(P.next.item);
            System.out.print(" ");
            P = P.next;
        }
        System.out.print("\n");
    }

    public LinkedListDeque() {
        sentinel = new DequeNode(null,null,null);
        size = 0;
        last = null;
    }

    public void addFirst(T item){
        if (size == 0) {
            sentinel.next = new DequeNode(item,null,sentinel);
            last = sentinel.next;
        }
        else {
            sentinel.next = new DequeNode(item, sentinel.next,sentinel);
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(T item){
        if (size == 0) {
            addFirst(item);
            return;
        }
        else {
            last.next = new DequeNode(item,null,last);
            last = last.next;
        }
        size += 1;
    }

    public T removeLast() {
        if (size == 0)
            return null;
        T item = last.item;
        last = last.prev;
        last.next = null;
        size -= 1;
        return item;
    }

    public T removeFirst() {
        if (size == 0)
            return null;
        T item = sentinel.next.item;
        if (size == 1)
            sentinel.next = null;
        else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
        size -= 1;
        return item;
    }

    public T get(int index) {
        if (index > size - 1 || size == 0)
            return null;
        else{
            DequeNode P = sentinel;
            int i = 0;
            while (i < index){
                P = P.next;
                i++;
            }
            return P.next.item;
        }
    }
}
