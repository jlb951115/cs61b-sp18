public class LinkedListDeque<T> {
    private class DequeNode
    {
        public T item;
        public DequeNode next;
        public DequeNode prev;
        public DequeNode(T i, DequeNode n, DequeNode x)
        {
            item = i;
            next = n;
            prev = x;
        }
    }
    private DequeNode sentinel;
    private DequeNode last;
    private int size;
    public int size()
    {
        return  size;
    }

    public boolean isEmpty()
    {
        return sentinel.next == null;
    }

    public void printDeque()
    {
        DequeNode P = sentinel;
        while(P.next != null)
        {
            System.out.print(P.item);
            System.out.print(" ");
            P = P.next;
        }
    }

    public LinkedListDeque()
    {
        sentinel = new DequeNode(null,null,null);
        size = 0;
        last = null;
    }

    public LinkedListDeque(DequeNode i, DequeNode n, int s)
    {
        sentinel = i;
        last = n;
        size = s;
    }
    public void addFirst(T item)
    {
        if (size == 0)
        {
            sentinel.next = new DequeNode(item,null,sentinel);
            last = sentinel.next;
        }
        else
        {
            sentinel.next = new DequeNode(item, sentinel.next,sentinel);
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(T item)
    {
        if (size == 0)
            addFirst(item);
        else
        {
            last.next = new DequeNode(item,null,last);
            last = last.next;
        }
        size += 1;
    }

    public void removeLast()
    {
        if (size == 0)
            return;
        else
        {
            last = last.prev;
            last.next = null;
        }
        size -= 1;
    }

    public void removeFirst()
    {
        if (size == 0)
            return;
        else if (size == 1)
        {
            sentinel.next = null;
        }
        else
        {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
        size -= 1;
    }
    public T get(int index)
    {
        if (index > size - 1)
            return null;
        else
        {
            DequeNode P = sentinel;
            int i = 0;
            while (i < index)
            {
                P = P.next;
                i++;
            }
            return P.next.item;
        }
    }

    public T getRecursive(int index)
    {
        if (index == 0)
            return sentinel.next.item;
        else
            return new LinkedListDeque<T>(sentinel.next,last,size-1).getRecursive(index-1);
    }
}
