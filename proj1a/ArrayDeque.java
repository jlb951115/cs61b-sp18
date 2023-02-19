public class ArrayDeque<Item>
{
    private Item[] items;
    private int size;
    private int nextfirst;
    private int nextlast;
    public ArrayDeque()
    {
        size = 0;
        items = (Item[]) new Object[8];
        nextfirst = 4;
        nextlast = 5;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public Item get(int index)
    {
        return items[index];
    }

    public Item getLast()
    {
        if (size == 0)
            return null;
        else
            return items[minusone(nextlast,items.length)];
    }

    public Item getFirst()
    {
        if (size == 0)
            return null;
        else
            return items[plusone(nextfirst,items.length)];
    }

    private void resize(int cap)
    {
        Item[] a = (Item[]) new Object[cap];
        int number = size;
        int i = 0;
        int index = nextfirst;
        while (number > 0)
        {
            a[i] = items[plusone(index,items.length)];
            i++;
            number--;
            index = plusone(index,items.length);
        }
        items = a;
        nextfirst = minusone(0,items.length);
        nextlast = size;
    }
    private int minusone(int index, int capt)
    {
        if (index - 1 < 0)
            return capt - 1;
        else
            return index - 1;
    }

    private int plusone(int index, int capt)
    {
        if (index + 1 == capt)
            return 0;
        else
            return index + 1;
    }
    public void addFirst(Item item)
    {
        if (size == items.length)
            resize(size * 2);
        items[nextfirst] = item;
        nextfirst = minusone(nextfirst,items.length);
        size += 1;
    }

    public void addLast(Item item)
    {
        if (size == items.length)
            resize(size * 2);
        items[nextlast] = item;
        nextlast = plusone(nextlast, items.length);
        size += 1;
    }

    public Item removeFirst()
    {
        if (size == 0)
            return null;
        size -= 1;
        nextfirst = plusone(nextfirst, items.length);
        return items[nextfirst];
    }

    public Item removeLast()
    {
        if (size == 0)
            return null;
        size -= 1;
        nextlast = minusone(nextlast,items.length);
        return items[nextlast];
    }

    public void printDeque()
    {
        int i = 0;
        int index = nextfirst;
        while(i < size)
        {
            System.out.print(items[plusone(index,items.length)]);
            System.out.print(" ");
            index = plusone(index,items.length);
            i++;
        }
        System.out.print("\n");
    }
}
