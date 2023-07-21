package app;

import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void push(T v) {
        queue.addLast(v);
    }

    public void pop() {
        if (!empty()) {
            queue.removeFirst();
        }
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public T front() {
        if (!empty()) {
            return queue.getFirst();
        }
        return null;
    }
}


