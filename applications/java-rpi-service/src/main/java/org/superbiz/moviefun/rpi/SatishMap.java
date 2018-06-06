package org.superbiz.moviefun.rpi;

public class SatishMap {

    private int size = 0;
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    //you said addItem
    // you said name as String, which is OK too
    public void put(Object name, Object value) {
        int i = indexOf(name);
        if (i != -1){
            values[i]=value;
        }
        else {
            keys[size] = name;
            values[size] = value;
            size++;
        }
    }


    public int size() {
        return size;
    }

    public Object get(Object key) {
        int i =  indexOf(key);
        if (i != -1){
            return values[i];
        }
        return null;
    }

    private int indexOf(Object key){
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

}
