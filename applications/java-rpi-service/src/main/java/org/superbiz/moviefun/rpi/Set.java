package org.superbiz.moviefun.rpi;

public class Set {
    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();

        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        for (String string : strings) {
            randomizedQueue.enqueue(string);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(randomizedQueue.dequeue());
        }
    }

}
