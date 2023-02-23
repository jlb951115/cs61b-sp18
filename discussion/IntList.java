public class IntList {
    public int item;
    public IntList next;
    public IntList(int i, IntList n)
    {
        item = i;
        next = n;
    }

    public static IntList of(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.next) {
            p.next = new IntList(args[k], null);
        }
        return result;
    }

    public static IntList square(IntList L)
    {
        if (L.next == null)
            return new IntList(L.item * L.item, null);
        else
            return new IntList(L.item * L.item, square(L.next));
    }

    public static IntList squareMutative(IntList L)
    {
        if (L.next == null)
        {
            L.item = L.item * L.item;
            return L;
        }
        else
        {
            L.item = L.item * L.item;
            L.next = squareMutative(L.next);
            return L;
        }
    }

    public static IntList squarei(IntList L)
    {
        if (L == null)
            return null;
        IntList x = new IntList(1,null);
        IntList P = x;
        while (L.next != null)
        {
            x.item = L.item * L.item;
            x.next = new IntList(1,null);
            L = L.next;
            x = x.next;
        }
        x.item = L.item * L.item;
        return P;
    }

    public void skipify()
    {
        IntList p = this;
        int n = 1;
        while ( p != null)
        {
            IntList next = p.next;
            for (int i = 0; i < n; i++)
            {
                if (next == null)
                {
                    break;
                }
                next = next.next;
            }
            n++;
            p.next = next;
            p = p.next;
        }
    }

    public static void removeDuplicates(IntList p)
    {
        if (p == null)
            return;
        IntList current = p.next;
        IntList previous = p;
        while(current != null)
        {
            if (previous.item == current.item)
            {
                previous.next = previous.next.next;
            }
            else
            {
                previous = previous.next;
            }
            current = previous.next;
        }
    }
    public static void main(String[] args)
    {
        IntList C = IntList.of(1,2,2,2,3);
        IntList.removeDuplicates(C);
    }
}
