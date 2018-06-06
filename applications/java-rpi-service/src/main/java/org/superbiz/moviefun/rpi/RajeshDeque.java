package org.superbiz.moviefun.rpi;

import java.util.Iterator;

public class RajeshDeque<Item> implements Iterable<Item> {

    private InternalItem<Item> firstItem = null;
    private InternalItem<Item> lastItem = null;

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void addFirst(Item item) {
        if (null == item) {
            throw new NullPointerException("can't add null");
        }
        if (firstItem == null) {
            InternalItem<Item> onlyItem = new InternalItem<>();
            onlyItem.value = item;
            firstItem = onlyItem;
            lastItem = onlyItem;
        } else {
            InternalItem<Item> oldIFirsttem = firstItem;
            firstItem = new InternalItem<>();
            firstItem.value = item;
            firstItem.nextItem = oldIFirsttem;
            oldIFirsttem.previousItem = firstItem;

        }
        size++;

    }

    public void addLast(Item item){
        if (null == item){
            throw new NullPointerException("can't add null");
        }
        if (lastItem == null){
            InternalItem<Item> onlyItem = new InternalItem<>();
            onlyItem.value = item;
            firstItem = onlyItem;
            lastItem = onlyItem;
        }else{
            InternalItem<Item> oldLastItem = lastItem ;
            lastItem = new InternalItem<>();
            lastItem.value = item;
            lastItem.previousItem = oldLastItem;
            oldLastItem.nextItem = lastItem;
        }
        size++;
    }


    public InternalItem<Item> fetchFirst() {
        return firstItem;
    }

    public InternalItem<Item> fetchLast() {
        return lastItem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ForwardIterator();
    }

    private static class InternalItem<Item> {
        private Item value;
        private InternalItem<Item> nextItem;
        private InternalItem<Item> previousItem;

    }

    private class ForwardIterator implements Iterator<Item> {
        private InternalItem<Item> currentItem = firstItem;

        @Override
        public boolean hasNext() {
            return currentItem != null;
        }

        @Override
        public Item next() {
            InternalItem<Item> currentItem = firstItem;
            Item returnValue = currentItem.value;
            currentItem = currentItem.nextItem;
            return returnValue;
        }
    }
}
