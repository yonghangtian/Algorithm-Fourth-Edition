import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author tianyh
 * this is an implementation of stack using linked list.
 */
public class LinkedListStack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public LinkedListStack(){
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

    public Item pop(){
        Item item = first.item;
        first = first.next;
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
        LinkedListStack<String> stringStack = new LinkedListStack<>();
        stringStack.push("abcdefg");
        stringStack.push("abcdef");
        stringStack.push("abcde");
        System.out.println(stringStack.pop());
        for(String a : stringStack){
            System.out.println(a);
        }
    }
}
