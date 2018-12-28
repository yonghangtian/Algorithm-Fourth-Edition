/**
 * @author tianyh
 * this is an implementation of bag using linked list.
 */
import java.util.Iterator;
import java.util.ListIterator;

public class LinkedListBag<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public LinkedListBag(){
        first = null;
        N = 0;
    }
    public boolean empty(){
        //since we only need one pointer: first here, we can use N ==0 as empty.
        return first == null;
//        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
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
        LinkedListBag<String> stringBag = new LinkedListBag<>();
        stringBag.push("abcdefg");
        stringBag.push("abcdef");
        stringBag.push("abcde");
        for(String a : stringBag){
            System.out.println(a);
        }
    }
}
