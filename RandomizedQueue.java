import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


// As ordering does not matter, use a resizing array
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size; // number of integer elements on stack
    private Item[] stack; // array of items
    private int stackIndex;

    /* Initalises an empty stack */
    public RandomizedQueue() {
        stack = (Item[]) new Object[2];
        size = 0;
        stackIndex = 0;
    }

   @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        // add to the list
        if (size == stack.length) {
            resize(2 * stack.length); // double the size of array if filled
        } else if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2); // halve the size of the array if number of elements is < 1/4 of array size
        }
        stack[size] = item; // add item
        size++;
    }

    public Item dequeue() {
        emptyQueueError();
        // Random rand = new Random();
        // The below will give a number between 0 - number of array elements
        stackIndex = StdRandom.uniform(stack.length);
        // stackIndex = rand.nextInt(stack.length);

        while (stack[stackIndex] == null) {
            stackIndex = StdRandom.uniform(stack.length);

        }
        Item item = stack[stackIndex];
        stack[stackIndex] = null;
        size--;
        return item;
    }

    // // This method needs to be removed
    // public Item stackItem(int i) {
    // return stack[i];
    // }

    // This method needs to be removed
    // public int returnOriginalStackSize() {
    // return stack.length;
    // }


    public Item sample() {
        // return a random item but do not remove it
        emptyQueueError();
        // Random rand = new Random();
        // The below will give a number between 0 - number of array elements
        Item item = null;
        while (item == null) {
            stackIndex = StdRandom.uniform(size);
            item = stack[stackIndex];
        }
        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        assert capacity >= size;
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    private void emptyQueueError() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item current;

        private int index;
        private final int[] arrayOfIntegers;

        public RandomizedQueueIterator() {
            arrayOfIntegers = new int[size];
            index = 0;
            for (int i = 0; i < arrayOfIntegers.length; i++) {
                arrayOfIntegers[i] = i;

            }

            /* Use the StdRandom class provided by assignment */
            StdRandom.shuffle(arrayOfIntegers);
        }

        /* returns next item in the iterator */
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There are no more items left in the array!");
            } else {    
                current = stack[arrayOfIntegers[index]];
                index++;
                return current;
            }

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return index != arrayOfIntegers.length;
        }
        // This method needs to be removed
        // private int testFunction() {
        //     return index;
        // }

    }

    public static void main(String[] args) {
        // RandomizedQueue<String> test = new RandomizedQueue<String>();
        // test.enqueue("blue");
        // test.enqueue("yellow");
        // test.enqueue("green");
        // test.enqueue("pink");
        // test.enqueue("red");
        // test.enqueue("purple");
        // test.enqueue("white");
        // test.enqueue("black");
        // test.enqueue("violet");
        // test.enqueue("indigo");
        
        // System.out.println(test.returnOriginalStackSize());
        // test.enqueue("green");
        // System.out.println(test.returnOriginalStackSize());
        // test.enqueue("pink");
        // Iterator<String> iterator = test.iterator();
        // System.out.println(iterator.hasNext());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        

        // System.out.println(iterator.hasNext());
        // index++;
        // System.out.println(iterator.hasNext());
        // index++;
        // System.out.println(iterator.hasNext());
        // System.out.println(test.size());

        // System.out.println(test.dequeue());
        // System.out.println(test.size());
        // System.out.println(test.dequeue());
        // System.out.println(test.size());
        // System.out.println(test.dequeue());
        // System.out.println(test.size());
        // System.out.println(test.dequeue());
        // System.out.println(test.size());

        // Iterator iterator = test.iterator();

        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.next());
        // System.out.println(iterator.hasNext());

    }
}

