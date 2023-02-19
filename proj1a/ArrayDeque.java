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
            return items[nextlast-1];
    }

    public Item getFirst()
    {
        if (size == 0)
            return null;
        else
            return items[nextfirst+1];
    }
    private void resize(int capticy)
    {
        if (nextfirst+1 < nextlast-1)
    }
    public void addFirst(Item item)
    {
        items[nextfirst] = item;
        size += 1;
        nextfirst -= 1;
    }
}
