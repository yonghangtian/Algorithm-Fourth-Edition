import java.util.Iterator;

/**
 * This class creates a Resizing Array Stack which usage rate is larger than (1/4) of array's length.
 * @param <Item>
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    // array for stack
    private Item[] a;
    // size of stack
    private int N = 0;

    public ResizingArrayStack()
    { a = (Item[]) new Object[1]; }

    public boolean empty()  { return N == 0; }
    public int size()       { return N; }
    public boolean full()   { return N == a.length; }

    public void resize(int max)
    {   //move stack to a new array of size max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N ; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item)
    {   // add item to the top of stack
        if(full())   { resize(2*a.length); }
        // N++ means return N first, then N+1
        a[N++] = item;
    }

    public Item pop()
    {   // remove item form the top of stack
        // --N means return N-1 directly.
        Item item = a[--N];
        // avoid loitering(游离, means that useless and can not be collect as garbage by JAVA.)
        a[N] = null;
        // if N == (1/4) a.length, then resize a.length to its 1/2.
        if(N > 0 && N == (1/4)*a.length){ resize((1/2)*a.length); }
        return item;
    }
    @Override
    public Iterator<Item> iterator()
    { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<Item>
    {   //support LIFO iteration.
        private int i = N;
        @Override
        public boolean hasNext()   { return i > 0; }
        @Override
        public Item next()         { return a[--i]; }
        @Override
        public void remove()       { }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Double> stack = new ResizingArrayStack<>();
        stack.push(2.0);
        stack.push(3.0);
        stack.push(4.001);
        stack.push(5.0);
        for (Double i : stack)  {
            System.out.println(i);
        }
        stack.pop();
        stack.pop();
        for (Double i : stack)  {
            System.out.println(i);
        }
    }
}
