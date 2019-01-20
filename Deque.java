import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    // From Algorithms (Sedgewick) book, start with a nested class that defines
    // the node abstraction
    private class Node {
        // These values are intially intialised to null during creation
        Item item;
        Node next;
        Node prev;


    }

    public Deque() {
        // construct empty deque
    }

   // class Deque<Item> must implement all methods of interface
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // public Item returnItem(Node node) {
    //     return node.item;
    // }

    // public Node returnFirstNode() {
    //     return first;
    // }

    public void addFirst(Item item) {
        nullItemException(item);
        if (size() != 0) {
            // save a link to the first nodeirst.item == null
            Node oldfirst = first;
            // create a new node for the beginning
            first = new Node();
            // set the instance variable in the new node
            first.item = item;
            // link new node to beginning of list
            first.next = oldfirst;
            // System.out.println("first.next is " + returnItem(first.next));
            oldfirst.prev = first;
            // System.out.println("oldfirst.prev is " + returnItem(oldfirst.prev));
            

        }

        else {
            first = new Node();
            first.item = item;

            // last = new Node();
            last = first;
       }
       size++;

    }

    public void addLast(Item item) {
        nullItemException(item);
        if (size() != 0) {
            // save a link to the last node
            Node oldlast = last;
            // create a new node for the end
            last = new Node();
            last.item = item;
            // link the new node to the end of the list
            oldlast.next = last;

            last.prev = oldlast;

            size++;
        } else {
            last = new Node();
            last.item = item;

            first = last;

            size++;
        }
    }

    public Item removeFirst() {
        emptyElementException();
        // oldfirst node becomes an orphan and the
        // memory management system reclaims that chunk of memory
        Node oldfirst = first;
        Node oldnext = first.next;

        Item result = oldfirst.item;
        first = first.next;

        
    if (size == 1) {
        last = null;
    }
    else {
        first.prev = null;
        first.next = oldnext.next;
    }
        size--;
        return result;
    }

    public Item removeLast() {
        emptyElementException();
        // trasverse the whole list to find the node that links to last node
        Node oldlast = last;
        Node oldprev = oldlast.prev;

        Item result = oldlast.item;

        last = last.prev;  

        if ( size == 1 ) {

            first = null;
        } 
        else {
            last.next = null;     
            last.prev = oldprev.prev;
        }     

        size--;
        return result;
    }

    // separate private methods for exception errors 
    private void nullItemException(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        else return;
    }

    private void emptyElementException() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        else return;
    }

    private class DequeIterator implements Iterator<Item> {
        
        private Node current;

        public DequeIterator() {
            this.current = first;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("There is no item next in the iterator");
            }
            else {
            Item lastItem = current.item;
            current = current.next;
            return lastItem;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

    }

    public static void main(String[] args) {
        // Deque<String> deque = new Deque<String>();
        // deque.addFirst("pink");
        // deque.addFirst("red");
        // deque.addFirst("blue");
        // System.out.println(deque.removeLast());
        // System.out.println(deque.removeLast());
        // System.out.println(deque.removeFirst());
        // deque.addFirst("red");
        // deque.addLast("blue");
        // deque.addLast("green");
        // System.out.println(deque.removeLast());
        // System.out.println(deque.removeFirst());
        // System.out.println(deque.size());  
        
        // Iterator<String> iterator = deque.iterator();
        // System.out.println(iterator.hasNext());
        
        // System.out.println(iterator.next());
        // System.out.println(iterator.hasNext());
        // System.out.println(iterator.next());
        // System.out.println(iterator.hasNext());
        // System.out.println(iterator.next());






    }

}
