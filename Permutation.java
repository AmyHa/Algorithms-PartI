import edu.princeton.cs.algs4.StdIn;

public class Permutation {

    public Permutation() {

    }

    public static void main(String[] args) {

        /*
         * Execute the class using the command below: cmd /c --% java Permutation [int]
         * < [textfile].txt Replacing [int] with integer k, and [textfile] with the name
         * of a text file in the same working directory
         * 
         * Meaning of the first 3 prefixes: cmd invokes cmd.exe, which knows what you
         * mean by < /c tells cmd.exe to process one command following the command line
         * and then exit --% tells PowerShell to leave the rest of the command line
         * alone, so that cmd.exe can deal with the < redirection.
        * 
         * The program simply... [explain what the program does]
         */

        // Takes in integer k as first command-line argument - k must be an integer
        int k;
        // if (args.length > 0) {
        // try {
        // k = Integer.parseInt(args[0]);
        // } catch (NumberFormatException e) {
        // System.err.println("Argument " + args[0] + " must be an integer.");
        // System.exit(1);
        // }
        // }

        /*
         * We can't use RandomizedQueue, as the size of the array is not equal to the
         * number of items in text file. The assignment specifies that in this program,
         * the size of the array must use a constant amount of memory plus either one
         * Deque or RandomizedQueue object of maximum size at most n
         * 
         */
        RandomizedQueue<String> RQ = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            RQ.enqueue(c);
        }

        k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            System.out.println(RQ.dequeue());
        }

        // Deque<String> deque = new Deque<String>();
        // while (!StdIn.isEmpty()) {
        // String c = StdIn.readString();
        // deque.addLast(c);
        // }

        // int size = deque.size();
        // int stackIndex;
        // stackIndex = StdRandom.uniform(size);

    }

}
