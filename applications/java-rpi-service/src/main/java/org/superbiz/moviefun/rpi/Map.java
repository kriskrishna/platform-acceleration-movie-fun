package org.superbiz.moviefun.rpi;
public class Map {

    int size = 0;
    Object[] keys = new Object[10];
    Object[] values = new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(Object k, Object v) {
        int i = indexOf(k);
        if (i != -1) {
            values[i] = v;
        } else {
            if (size == keys.length) {
                Object[] tempKeys = new Object[2 * size];
                Object[] tempValues = new Object[2 * size];

                System.arraycopy(keys, 0, tempKeys, 0, size);
                System.arraycopy(values, 0, tempValues, 0, size);

                keys = tempKeys;
                values = tempValues;
            }

            keys[size] = k;
            values[size] = v;
            size++;
        }
    }

    public int size() {
        return size;
    }

    private int indexOf(Object k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                return i;
            }
        }

        return -1;
    }

    // [1][2][][][][][][]
    public Object get(Object k) {
        int i = indexOf(k);
        if (i != -1) {
            return values[i];
        } else {
            return null;
        }
    }

    //keys [3][2][][][][][][]
    //vals [c][b][][][][][][]

    public void remove(Object k) {
        int i = indexOf(k);
        if (i != -1) {
            keys[i] = keys[size - 1];
            values[i] = values[size - 1];
            size--;
        }
    }

}
