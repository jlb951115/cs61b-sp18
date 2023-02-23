public class SLList {
    private class IntNode{
        public int item;
        public IntNode next;
        public  IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;

    public SLList()
    {
        first = null;
    }

    public void addFirst(int item)
    {
        first = new IntNode(item,first);
    }

    public void insert(int item, int position){
        if (position == 0)
        {
            addFirst(item);
            return;
        }
        int i = 0;
        IntNode temp = first;
        while (i < position - 1)
        {
            temp = temp.next;
            i++;
        }
        temp.next = new IntNode(item, temp.next);
    }

    public void insert_recur(int item, int position)
    {
        first = helper(first, item, position);
        return;
    }

    private IntNode helper(IntNode node, int item, int position)
    {
        if (position == 0)
            return new IntNode(item, node);
        else
            return new IntNode(node.item, helper(node.next, item, position-1));
    }

    public void reverse()
    {
        IntNode head = first;
        IntNode tail = null;
        while(head != null)
        {
            IntNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        first = tail;
    }

    private  IntNode rev(IntNode node)
    {
        if (node == null || node.next == null)
            return node;
        else {
            IntNode rever = rev(node.next);
            node.next.next = node;
            node.next = null;
            return rever;
        }
    }

    public void  reve()
    {
        first = rev(first);
    }

    public static void main(String[] args)
    {
        SLList t = new SLList();
        t.addFirst(6);
        t.addFirst(9);
        t.addFirst(3);
        t.insert(0,1);
        t.insert(7,2);
        t.insert_recur(2,3);
        t.reve();
        System.out.println("fadsf");
    }
}
