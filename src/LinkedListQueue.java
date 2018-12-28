import java.util.Iterator;

/**
 * @author tianyh
 * this is an implementation of queue using linked list.
 */
public class LinkedListQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public LinkedListQueue(){
        first = null;
        last = null;
        N = 0;
    }
    public boolean empty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(empty()){
            first = last;
        } else{
            oldLast.next = last;
        }
        N++;
    }

    public Item remove(){
        Item item = first.item;
        first = first.next;
        if(empty()){
            last = null;
        }
        N--;
        return  item;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }

    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.add("abcd");
        queue.add("abcde");
        queue.add("abcdef");
        System.out.println(queue.remove());
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
