package app;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<T> {
    private ArrayList<T> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(T v) {
        data.add(v);
    }

    public int size() {
        return data.size();
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public T top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }
}




