package com.inheritance;

public class QueueDemo {

    private Object[] q = new Object[5];
    private int len = 0;

    public boolean add(Object obj) {
        if (q != null && q.length > len) {
            q[len] = obj;
            len++;
            return true;
        }
        return false;
    }

    public boolean remove() {
        if (q != null && len > 0) {
            for (int i = 0; i < len; i++) {
                q[i] = q[i++];
            }
            len--;
            return true;
        }
        return false;
    }

    public Object peek() {
        if (len > 0) {
            return q[0];
        }
        return null;
    }

    public Object poll() {
        if (q != null && len > 0) {
            Object p = q[0];
            for (int i = 0; i < len; i++) {
                q[i] = q[i++];
            }
            len--;
            return p;
        }
        return null;
    }
}


